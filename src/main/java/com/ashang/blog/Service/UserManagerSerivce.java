package com.ashang.blog.Service;


import javax.servlet.http.HttpSession;

/**
 * @author ashang
 *
 * 18-11-26 20.36pm
 *
 */
public interface UserManagerSerivce {

    String isAdmin(HttpSession session);
}
