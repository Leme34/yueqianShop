package com.lee.yueqian.aspect;

import com.lee.yueqian.exception.AdminAuthorizeException;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 要想把一个类变成切面类，需要两步，
    ① 在类上使用 @Component 注解 把切面类加入到IOC容器中
    ② 在类上使用 @Aspect 注解 使之成为切面类
 */
@Aspect
@Component
public class AdminAuthorizeAspect {
    //访问一下类和方法时都会调用此切入点
    @Pointcut("execution(public * com.lee.yueqian.controller.admin.*.*(..))"
            +"&& !execution(public * com.lee.yueqian.controller.admin.*.init(..))"
            +"&& !execution(public * com.lee.yueqian.controller.admin.AdminLoginController.*(..))")
    public void verify(){}

    //检查登录状态
    @Before("verify()")
    public void doverify(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        HttpSession httpSession = httpServletRequest.getSession();
        String username = (String) httpSession.getAttribute("username");
        //未登录则抛异常交给异常处理器处理
        if(username == null && !"admin".equals(username)){
            throw new AdminAuthorizeException();
        }
    }



}
