package com.lee.yueqian.handler;

import com.lee.yueqian.exception.AdminAuthorizeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice   //异常处理器类的注解
public class AdminAuthorizeExceptionHandler {

    //拦截登录异常的处理器
    @ExceptionHandler(value = AdminAuthorizeException.class) //需要拦截的异常类名
    public void handlerAdminAuthorizeException(HttpServletRequest request, HttpServletResponse response){
        //携带错误信息跳转重新登录页
        request.setAttribute("msg","请先登录");
        try {
            request.getRequestDispatcher("login").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
