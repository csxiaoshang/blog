package com.ashang.blog.Controller;

import com.ashang.blog.Dao.ArticleCommonDao;
import com.ashang.blog.Entity.Article;
import com.ashang.blog.Entity.ArticleCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/article")
public class articleController {

    @Autowired
    ArticleCommonDao articleCommonDao;

    @GetMapping(path = "/add")
    public String addArticle(){
            return  "article";

    }

    @RequestMapping(path = "/common",method = RequestMethod.POST)
    @ResponseBody
    public List<ArticleCommon> articleCommon(){
        List<ArticleCommon> a= articleCommonDao.findAll();
        return  a;
    }

}
