package com.ashang.blog.Entity.Utils;

import com.ashang.blog.Entity.Constant.Status;
import com.ashang.blog.Entity.Response.Resp;

/**
 * @Author ashang
 * @Date 19-1-18 上午11:12
 * @Description 返回信息工具类
 **/
public class RespUtil {
    public static <T> Resp<T> successResp(T data){
        Resp<T> resp=new Resp<>();
        resp.setError_code(Status.Api.SUCCESS.getCode());
        resp.setError_message(Status.Api.SUCCESS.getMsg());
        resp.setData(data);
        return resp;
    }

    public static Resp successResp(){
        return successResp(null);
    }

    public static  Resp errorResp(Integer errorCode,String errorMsg){
        Resp resp=new Resp();
        resp.setError_code(errorCode);
        resp.setError_message(errorMsg);
        resp.setData(null);
        return resp;
    }
}
