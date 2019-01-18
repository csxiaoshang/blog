package com.ashang.blog.Service;

import com.ashang.blog.Entity.Response.Resp;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Entity.UserD;

import java.util.List;

/**
 * @author ashang 9700090853@qq.com
 *  18-11-05   11:05am
 */
public interface UserService {
    /**
     * 登录函数
     * @param user
     */
    Resp login(User user);

    /**
     * 注册函数
     *
     */
    void register(User user);

    /**
     * 用户展示函数
     *
     */
    List<UserD> findAll();
}
