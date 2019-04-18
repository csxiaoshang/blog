package com.ashang.blog.Service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ashang.blog.Entity.User;
import com.ashang.blog.Entity.Utils.RedisUtil;
import com.ashang.blog.Service.TokenService;
import nl.bitwalker.useragentutils.UserAgent;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ashang  liuys@bupt.edu.cn
 * @Date 19-4-18 下午4:40
 * <p>
 * 类说明：
 */
@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String generateToken(String userAgentStr, String username) {
        StringBuilder token=new StringBuilder("token:");
        //设备
        UserAgent userAgent=UserAgent.parseUserAgentString(userAgentStr);
        if (userAgent.getOperatingSystem().isMobileDevice()){
            token.append("MOBILE-");
        }else {
            token.append("PC_");
        }
        //加密的用户名
        token.append(DigestUtils.md5Hex(username)+"-");
        //时间
        token.append(new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date())+"-");
        //六位随机字符串
        token.append(new Random().nextInt(999999-111111+1)+111111);
        System.out.println("token->"+token.toString());
        return token.toString();
    }

    /**
     * 用token作为key存储登录成功的用户，即记录用户登录信息
     * @param token
     * @param user
     */
    @Override
    public void save(String token, User user) {
        if (token.startsWith("token:PC")){
            redisUtil.setHours(token, JSONObject.toJSONString(user),2);
        }else {
            redisUtil.set(token,JSONObject.toJSONString(user));
        }
    }
}
