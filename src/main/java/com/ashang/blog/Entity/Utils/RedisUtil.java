package com.ashang.blog.Entity.Utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author ashang  liuys@bupt.edu.cn
 * @Date 19-4-18 下午4:29
 * <p>
 * 类说明：
 */
@Component
public class RedisUtil {
    @Autowired
    RedisTemplate<String,String> redisTemplate;

    public void set(String key,String value){
        ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    public void setHours(String key,String value,int hours){
        ValueOperations<String,String> valueOperations=redisTemplate.opsForValue();
        valueOperations.set(key,value,hours, TimeUnit.HOURS);
    }
}
