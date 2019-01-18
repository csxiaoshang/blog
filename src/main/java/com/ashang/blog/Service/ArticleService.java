package com.ashang.blog.Service;

import com.ashang.blog.Entity.Article;
import com.ashang.blog.Entity.Response.Resp;
import com.ashang.blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleService  {

    Resp addArticle(Article article, User user);
}
