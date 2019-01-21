package com.ashang.blog.Service.impl;

import com.ashang.blog.Dao.CommentDao;
import com.ashang.blog.Entity.Comment;
import com.ashang.blog.Entity.Response.Resp;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Entity.Utils.RespUtil;
import com.ashang.blog.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author ashang
 * @Date 19-1-21 下午4:50
 * @Description TODO
 **/
public class CommentServiceImpl implements CommentService {

    @Autowired
    CommentDao commentDao;

    @Override
    public Resp addComment(HttpSession session, String content, Long articleId) {
        User user= (User) session.getAttribute("user");
        Comment comment=new Comment();
        comment.setUserId(user.getId());
        comment.setArticleId(articleId);
        comment.setContent(content);
        commentDao.save(comment);
        return RespUtil.successResp();
    }

    @Override
    public Resp displayComment(Long articleId) {
        List<Comment> list=commentDao.findCommentByArticleId(articleId);
        return RespUtil.successResp(list);
    }
}
