package com.ashang.blog.Entity.Response;

import lombok.Data;

/**
 * @author ashang  liuys@bupt.edu.cn
 * @Date 19-4-18 下午4:20
 * <p>
 * 类说明：
 * redis token class
 */
@Data
public class Dto {
    private String token;

    //token create time
    private String tokenCreatedTime;

    //token useless time
    private String tokenExpiryTime;

    private String isLogin;
}
