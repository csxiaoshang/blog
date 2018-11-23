package com.ashang.blog.Controller;

import com.ashang.blog.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(path = "/user")
//@CrossOrigin(origins = "http://localhost:8001",maxAge = 3600)
public class userController{

    @RequestMapping(path = "/self",method = RequestMethod.POST)
    @ResponseBody
        public User self(HttpSession httpSession){
            User user= (User) httpSession.getAttribute("user");
            System.out.println(user);
            return user;
        }
}
