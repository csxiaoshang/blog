package com.ashang.blog.Controller;

import com.ashang.blog.Dao.UserDao;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.impl.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/blog")
//@CrossOrigin(origins = "http://localhost:8001",maxAge = 3600)
public class indexController {

    @Autowired
    private UserDao userDao;

    @Autowired
    UserServiceImpl userService;

    @GetMapping(path = "/index")
    @ResponseBody
    public String index(){
        return "hao!";
    }

    @GetMapping(path ="/register")
    public String register(){
        return "/register.html";
    }

    @GetMapping(path = "/register/user")
    public String registeruser(User user){
        if(user.getUsername()==null||user.getPassword()==null){
            return "用户名或者密码不能为空";
        }
        userService.register(user);
        return "/login.html";
    }

    @GetMapping(path = "/login")
    public String login(User user , HttpServletRequest request){
        if(userService.login(user)){
            HttpSession httpSession=request.getSession(true);
            httpSession.setAttribute("user",user);
            String str="success";
            return str;
        }
        return "/index.html";
    }


}
