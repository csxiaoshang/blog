package com.ashang.blog.Controller;

import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.RequestWrapper;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(path = "/blog")
public class indexController {



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


}
