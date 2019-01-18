package com.ashang.blog.Service;


import com.ashang.blog.Entity.Response.Resp;

import javax.servlet.http.HttpSession;

/**
 * @author ashang
 *
 * 18-11-26 20.36pm
 *
 */
public interface UserManagerSerivce {

    Resp isAdmin(HttpSession session);
}
