package com.ashang.blog.Controller;

import com.ashang.blog.Dao.UserDao;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.impl.UserServiceImpl;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.RequestWrapper;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/blog")
public class indexController {

    @Autowired
    private UserDao userDao;

    @Autowired
    UserServiceImpl userService;
    @GetMapping(path = "/index")
    public List<String> index(Model model){
        List<String> titleList=new ArrayList<String>();
        titleList.add("nihao");
        titleList.add("bushihenhao");
        return titleList;
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
    public String login(User user){
        if(userService.login(user)){
            return "/index.html";
        }
        return "请重新输入密码";
    }


}
