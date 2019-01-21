package com.ashang.blog.Dao;

import com.ashang.blog.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentDao extends JpaRepository<Comment,Long> {

    List<Comment> findCommentByArticleId(Long articleId);
}
