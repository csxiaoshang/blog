package com.ashang.blog.Entity.Response;

import lombok.Data;

/**
 * @author ashang
 *@version 2019/1/18
 *
 * 返回信息类
 */
@Data
public class Resp<T> {

    /**
     * error_code: 信息码
     * error_message: 错误信息
     * data:{}
     */
    private Integer error_code;
    private String  error_message;
    private T data;
}
