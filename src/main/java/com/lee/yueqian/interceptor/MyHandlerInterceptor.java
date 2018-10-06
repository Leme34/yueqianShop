package com.lee.yueqian.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String username = (String) request.getSession().getAttribute("username");
        //若直接请求内部url则过滤并跳转登录页
        if(username == null && !"admin".equals(username)){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("login").forward(request,response);
            return false;
        }
        //已登录则放行
        else return true;
    }

}
