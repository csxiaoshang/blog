package com.ashang.blog.Controller;

import com.ashang.blog.Dao.ArticleCommonDao;
import com.ashang.blog.Dao.ArticleDao;
import com.ashang.blog.Entity.Article;
import com.ashang.blog.Entity.ArticleCommon;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(path = "/article")
//@CrossOrigin(origins = "http://localhost:8001",maxAge = 3600)
public class articleController {

    @Autowired
    ArticleCommonDao articleCommonDao;

    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    ArticleDao articleDao;
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public void addArticle(HttpSession httpSession, Article article, HttpServletResponse response) throws IOException {
            User user= (User) httpSession.getAttribute("user");
            articleService.addArticle(article,user);
            response.sendRedirect("/articles.html");
    }

    @RequestMapping(path = "/common",method = RequestMethod.POST)
    @ResponseBody
    public List<ArticleCommon> articleCommon(){
        List<ArticleCommon> a= articleCommonDao.findAll();
        return  a;
    }

    @RequestMapping(path = "/user",method =RequestMethod.POST)
    @ResponseBody
    public  List<Article> articled(HttpSession httpSession){
        User user= (User) httpSession.getAttribute("user");
        List<Article> a= articleDao.findByUserId(user.getId());
        return a;
    }

}
