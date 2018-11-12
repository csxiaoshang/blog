package com.ashang.blog.Dao;

import com.ashang.blog.Entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleDao extends JpaRepository<Article,Long> {
    List<Article> findByUserId(Long id);
}
