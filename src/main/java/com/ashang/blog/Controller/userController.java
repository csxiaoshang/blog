package com.ashang.blog.Controller;

import com.ashang.blog.Entity.User;
import com.ashang.blog.Entity.UserD;
import com.ashang.blog.Service.impl.UserManagerServiceImpl;
import com.ashang.blog.Service.impl.UserServiceImpl;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
//@CrossOrigin(origins = "http://localhost:8001",maxAge = 3600)
public class userController{


    @Autowired
    UserManagerServiceImpl userManagerService;

    @Autowired
    UserServiceImpl userService;

    /**
     * 用于在博客右上角个人中心位置显示用户名
     * @param httpSession  Session用于判别用户
     * @return  user类
     */
    @RequestMapping(path = "/self",method = RequestMethod.POST)
    @ResponseBody
        public User self(HttpSession httpSession){
            User user= (User) httpSession.getAttribute("user");
            return user;
        }

    /**
     * 登出操作 抹去Session保存的用户个人信息
     * @param request
     * @param response
     * @return
     */
        @GetMapping(path = "/logout")
        public String logout(HttpServletRequest request, HttpServletResponse response){

        HttpSession session=request.getSession(false);
        if(session==null){
            return "false";
        }
        session.removeAttribute("user");
        return "success";
        }

    /**
     * 判断是否拥有管理权限，在前端中判断是否能够管理用户
     * @param request
     * @return
     */
        @GetMapping(path = "/manager")
        public  String unarguable(HttpServletRequest request){
            HttpSession session=request.getSession(false);
            if(session==null)
                return "false";
            String string=userManagerService.isAdmin(session);
                if (string.equals("true")){
                    System.out.println("证实是root用户！");
                    String str= (String) session.getAttribute("admin");
                    if (str==null)
                        return "false";
                    if (str.equals("true")){
                        return "success";
                }else {
                    return "false";
                }
            }
            return "false";
        }

    /**
     * 查询当前用户
     * @return  UserD  包含用户ID 用户名 用户角色
     */
        @PostMapping(path = "/unman")
        @ResponseBody
       public  List<UserD> display(){
            List<UserD> userDS= userService.findAll();
            System.out.println(userDS);
            return userDS;
        }
}
