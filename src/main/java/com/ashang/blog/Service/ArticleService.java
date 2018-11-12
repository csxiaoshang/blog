package com.ashang.blog.Service;

import com.ashang.blog.Entity.Article;
import com.ashang.blog.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleService  {

    String addArticle(Article article, User user);
}
