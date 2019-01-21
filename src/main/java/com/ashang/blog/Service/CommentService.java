package com.ashang.blog.Service;

import com.ashang.blog.Entity.Response.Resp;

import javax.servlet.http.HttpSession;

/**
 * @Author ashang
 * @Date 19-1-21 下午4:49
 * @Description  评论逻辑接口
 **/
public interface CommentService {
    /**
     * 发表评论
     * @param session
     * @param content
     * @param articleId
     * @return
     */
    Resp addComment(HttpSession session, String content,Long articleId);

    /**
     * 显示评论
     * @param articleId
     * @return
     */
    Resp displayComment(Long articleId);
}
