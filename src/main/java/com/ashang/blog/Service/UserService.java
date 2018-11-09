package com.ashang.blog.Service;

import com.ashang.blog.Entity.User;

/**
 * @author ashang 9700090853@qq.com
 *  18-11-05   11:05am
 */
public interface UserService {
    /**
     * 登录函数
     * @param user
     */
    boolean login(User user);

    /**
     * 注册函数
     *
     */
    void register(User user);
}
