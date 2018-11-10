package com.ashang.blog.Dao;

import com.ashang.blog.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleDao extends JpaRepository<Article,Long> {
}
