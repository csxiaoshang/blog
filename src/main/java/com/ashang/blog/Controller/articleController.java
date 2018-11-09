package com.ashang.blog.Controller;

import com.ashang.blog.Entity.Article;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/article")
public class articleController {


    @RequestMapping(path = "/addarticle")
    public String addArticle(Article article){
            return  "sdfdf";

    }
}
