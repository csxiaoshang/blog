package com.ashang.blog.Service.impl;

import com.ashang.blog.Dao.ArticleDao;
import com.ashang.blog.Entity.Article;
import com.ashang.blog.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticleDao articleDao;

    @Override
    public String addArticle(Article article){
        Article a=new Article();
        a.setArticleContent(article.getArticleContent());
        a.setArticleDescription(article.getArticleDescription());
        a.setArticleTag(article.getArticleTag());
        a.setArticleTitle(article.getArticleTitle());
        articleDao.save(a);
        return "Success";
    }
}
