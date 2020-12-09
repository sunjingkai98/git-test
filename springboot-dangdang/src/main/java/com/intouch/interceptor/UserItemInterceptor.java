package com.intouch.interceptor;


import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserItemInterceptor implements HandlerInterceptor {

    //定义登陆请求
    private static final String LOGINURI = "/login/loginForm";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getContextPath();//项目名
        String servletPah = request.getServletPath();//用户的请求地址

        //如果是已经登陆的用户，放行（需将登陆的用户存入session中）
        if(request.getSession().getAttribute("loginUser") != null){
            return true;
        }
        //记录用户请求的URI
        request.getSession().setAttribute("targetURI", servletPah);
        //重定向到登陆页面
        response.sendRedirect(contextPath+LOGINURI);
        return false;
    }
}
