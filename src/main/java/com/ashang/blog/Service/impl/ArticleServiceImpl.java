package com.ashang.blog.Service.impl;

import com.ashang.blog.Dao.ArticleDao;
import com.ashang.blog.Entity.Article;
import com.ashang.blog.Entity.Response.Resp;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Entity.Utils.RespUtil;
import com.ashang.blog.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 文章管理逻辑类
 * @author ashang
 *
 */

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    /**
     * 添加个人文章
     * @param article  文章
     * @param user     发表文章用户
     * @return 是否添加个人文章成功标志
     */
    @Override
    public Resp addArticle(Article article, User user){
        Article a=new Article();
        a.setArticleContent(article.getArticleContent());
        a.setArticleDescription(article.getArticleDescription());
        a.setArticleTag(article.getArticleTag());
        a.setArticleTitle(article.getArticleTitle());
        a.setUserId(user.getId());
        articleDao.save(a);
        return RespUtil.successResp();
    }
}
