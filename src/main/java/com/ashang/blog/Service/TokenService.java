package com.ashang.blog.Service;

import com.ashang.blog.Entity.User;

/**
 * @author ashang  liuys@bupt.edu.cn
 * @Date 19-4-18 下午4:38
 * <p>
 * 类说明：
 */
public interface TokenService {

    String generateToken(String userAgentStr,String username);

    void save(String token, User user);
}
