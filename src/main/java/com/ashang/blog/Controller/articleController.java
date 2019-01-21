package com.ashang.blog.Controller;

import com.ashang.blog.Dao.ArticleCommonDao;
import com.ashang.blog.Dao.ArticleDao;
import com.ashang.blog.Entity.Article;
import com.ashang.blog.Entity.ArticleCommon;
import com.ashang.blog.Entity.Response.Resp;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Service.CommentService;
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

    @Autowired
    CommentService commentService;

    /**
     *填写发表个人博客
     * @param httpSession
     * @param article
     * @param response
     * @throws IOException
     */
    @RequestMapping(path = "/add",method = RequestMethod.POST)
    public Resp addArticle(HttpSession httpSession, Article article, HttpServletResponse response) throws IOException {
            User user= (User) httpSession.getAttribute("user");
            return articleService.addArticle(article,user);
    }

    /**
     * 查询公共博客文章
     * @return
     */
    @RequestMapping(path = "/common",method = RequestMethod.POST)
    @ResponseBody
    public List<ArticleCommon> articleCommon(){
        List<ArticleCommon> a= articleCommonDao.findAll();
        return  a;
    }

    /**
     * 查看个人博客
     * @param httpSession   传入Session用来判断用户
     * @return  当前用户的博客
     */
    @RequestMapping(path = "/user",method =RequestMethod.POST)
    @ResponseBody
    public  List<Article> articled(HttpSession httpSession){
        User user= (User) httpSession.getAttribute("user");
        List<Article> a= articleDao.findByUserId(user.getId());
        return a;
    }

    /**
     * 发表评论
     * @param session
     * @param content
     * @param articleId
     * @return
     */
    @RequestMapping(path = "/addcomment",method = RequestMethod.POST)
    public Resp addComment(HttpSession session,@RequestParam("content") String content,
                           @RequestParam("articleId") Long articleId){
        return commentService.addComment(session,content,articleId);
    }

    @RequestMapping(path = "displaycomment",method = RequestMethod.POST)
    public  Resp displayComment(@RequestParam("articleId") Long articleId){
        return commentService.displayComment(articleId);
    }
}
