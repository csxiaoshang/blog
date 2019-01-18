package com.ashang.blog.Entity.Constant;

/**
 * @Author ashang
 * @Date 19-1-18 上午11:15
 * @Description 状态码
 **/
public class Status {

    public enum Common{

        INVALID(0,"无效"),
        VALID(1,"有效"),
        DELETED(999,"已删除");

        private Integer code;
        private String msg;

        Common(Integer code,String msg){
            this.code=code;
            this.msg=msg;
        }


        public Integer getCode(){return code;}

        public String getMsg(){return msg;}
    }

    public enum Api{
        /**
         * 状态类型
         */
        SUCCESS(2000,"请求成功"),
        ERROR(2001,"请求错误");

        private Integer code;
        private String msg;

        Api(Integer code,String msg){
            this.code=code;
            this.msg=msg;
        }

        public Integer getCode(){return code;}

        public String getMsg(){return msg;}
    }
}
