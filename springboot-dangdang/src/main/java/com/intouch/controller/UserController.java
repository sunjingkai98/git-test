package com.intouch.controller;

import com.intouch.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.intouch.domain.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.HttpCookie;

@Controller
@RequestMapping("/login")
public class UserController {
    @Autowired
    private UserService service;

    @GetMapping("/loginForm")
    public String showLogin(Model model){
        model.addAttribute("user",new User());
        return "LoginForm";
    }

    @PostMapping("/verify")
    public String loginVerify(@Valid @ModelAttribute("user") User verifyUser, BindingResult bindingResult, Model model
            , HttpServletRequest request, HttpServletResponse response){
        //如果表单提交数据不规范，返回登陆表单
        if(bindingResult.hasErrors()){
            return "LoginForm";
        }
        //如果表单数据规范，则进行登陆处理
        User passUser = service.selectInfoByEmail(verifyUser.getEmail());
        //业务逻辑判断
        if(passUser != null && verifyUser.getPassword().equals(passUser.getPassword())){
            //记录当前用户登陆时间
            passUser.setLastLoginTime(System.currentTimeMillis());
            //记录当前用户登陆Ip地址
            passUser.setLastLoginIp(request.getRemoteAddr());
            //将信息同步到数据库中
            service.updataInfoByUser(passUser);
            //将登陆的用户存到session域中
            request.getSession().setAttribute("loginUser",passUser);
            //将登陆的用户的用户名保存在cookie中
            String userId = passUser.getId()+"";
            Cookie cookie = new Cookie("userId",userId);
            cookie.setMaxAge(-1);
            cookie.setPath("/");
            response.addCookie(cookie);

            //从session中拿出在拦截中拦截的用户请求的URI
            String targetURI = (String) request.getSession().getAttribute("targetURI");
            if(targetURI == null){//如果没有，那就是员工表单
                targetURI = "/dangdang/main";
            }
            //有效登录后，跳转到URI
            return "redirect:" + targetURI;

        }else{
            model.addAttribute("msg","用户邮箱或密码错误!");
            return "LoginForm";
        }

    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request,HttpServletResponse response){
        //从session域中删除以登陆的用户
        request.getSession().removeAttribute("loginUser");
        //将当前session无效掉
        request.getSession().invalidate();
        //删除cookie
        Cookie cookie = new Cookie("userId",null);
        cookie.setMaxAge(0);
        cookie.setPath("/");
        response.addCookie(cookie);

        //重定向到登陆页面
        return "redirect:/dangdang/main";

    }
}
