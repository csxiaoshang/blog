package com.ashang.blog.Aspect;


import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.impl.UserManagerServiceImpl;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *  AOP权限管理控制
 */
@Aspect
@Component
public class admin {

    @Pointcut("execution(public * com.ashang.blog.Service.impl.UserManagerServiceImpl.*(..))")
    public void users(){}

    @Before("users()")
    public void admin() {
        System.out.println("切入点获取成功");
        ServletRequestAttributes attributes= (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request=attributes.getRequest();
        HttpSession session=request.getSession(false);
        User user= (User) session.getAttribute("user");
        if(user.getUsername().equals("root")){
            session.setAttribute("admin","true");
        }else{
            session.setAttribute("admin","false");
        }

    }
}
