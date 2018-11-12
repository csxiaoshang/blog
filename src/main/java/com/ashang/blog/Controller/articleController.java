package com.ashang.blog.Controller;

import com.ashang.blog.Dao.ArticleCommonDao;
import com.ashang.blog.Dao.ArticleDao;
import com.ashang.blog.Entity.Article;
import com.ashang.blog.Entity.ArticleCommon;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/article")
public class articleController {

    @Autowired
    ArticleCommonDao articleCommonDao;

    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    ArticleDao articleDao;
    @GetMapping(path = "/add")
    public String addArticle(HttpSession httpSession,Article article){
            User user= (User) httpSession.getAttribute("user");
            articleService.addArticle(article,user);
            return  "/articleuser.html";

    }

    @RequestMapping(path = "/common",method = RequestMethod.POST)
    @ResponseBody
    public List<ArticleCommon> articleCommon(){
        List<ArticleCommon> a= articleCommonDao.findAll();
        return  a;
    }

    @RequestMapping(path = "/user",method =RequestMethod.GET)
    @ResponseBody
    public  List<Article> articleuser(HttpSession httpSession){
        User user= (User) httpSession.getAttribute("user");
        List<Article> a= articleDao.findByuserID(user.getId());
        return a;
    }

}
