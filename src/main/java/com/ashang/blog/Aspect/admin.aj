package com.ashang.blog.Aspect;

import com.ashang.blog.Service.impl.UserManagerServiceImpl;
import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author ashang
 *
 * 18-11-26 21:10pm
 */

@Aspect
public aspect admin {
    @Autowired UserManagerServiceImpl userManagerService;
    @Pointcut("execution(* com.ashang.blog.Controller.userController.unarguable(..))")
    private void users(){}

    @Before("users()")
    private void admin() {
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        HttpSession session=request.getSession(false);
        String string=userManagerService.isAdmin(session);
        if(string.equals("true")){
            String str="true";
            session.setAttribute("admin",str);
        }else {
            String str="false";
            session.setAttribute("admin",str);
        }
    }
}

