package com.intouch.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddItemInterceptor implements HandlerInterceptor {
    //定义登陆请求
    private static final String LOGINURI = "/login/loginForm";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String contextPath = request.getContextPath();//项目名
        //如果是已经登陆的用户，放行（需将登陆的用户存入session中）
        if(request.getSession().getAttribute("loginUser") != null){
            return true;
        }
        response.sendRedirect(contextPath+LOGINURI);
        return false;
    }
}
