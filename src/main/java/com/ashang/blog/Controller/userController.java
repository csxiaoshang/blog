package com.ashang.blog.Controller;

import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.impl.UserManagerServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(path = "/user")
//@CrossOrigin(origins = "http://localhost:8001",maxAge = 3600)
public class userController{


    @Autowired
    UserManagerServiceImpl userManagerService;


    @RequestMapping(path = "/self",method = RequestMethod.POST)
    @ResponseBody
        public User self(HttpSession httpSession){
            User user= (User) httpSession.getAttribute("user");
            System.out.println(user);
            return user;
        }

        @GetMapping(path = "/logout")
        public String logout(HttpServletRequest request, HttpServletResponse response){

        HttpSession session=request.getSession(false);
        if(session==null){
            return "false";
        }
        session.removeAttribute("user");
        return "success";
        }

        @GetMapping(path = "/manager")
        public  String unarguable(HttpServletRequest request){
            HttpSession session=request.getSession(false);
            if(session==null)
                return "false";
            String str= (String) session.getAttribute("admin");
            if(str.equals("true"))
                return "success";
            return "false";
        }
}
