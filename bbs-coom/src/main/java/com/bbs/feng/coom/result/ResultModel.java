package com.bbs.feng.coom.result;

import com.bbs.feng.coom.result.status.Result;

import javax.naming.spi.DirStateFactory;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/10 20:36
 * @since JDK 1.8
 */
public class ResultModel {

    private Integer status;

    private String massage;

    private Object body;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public ResultModel(Object body , Integer status , String massage , Long count){
        this.status = status;
        this.body = body;
        this.massage = massage;
    }

    public ResultModel(Integer status,String massage){
        this.status = status;
        this.body = null;
        this.massage = massage;
    }

    public ResultModel(Object body , Integer status , String massage){
        this.status = status;
        this.body = body;
        this.massage = massage;
    }

    public static ResultModel ok(Object body,Long count){
        return new ResultModel(body, Result.SUCCESS.getCode(),Result.SUCCESS.getMsg(),count);
    }

    public static ResultModel ok(Object body){
        return new ResultModel(body, Result.SUCCESS.getCode(),Result.SUCCESS.getMsg());
    }

    public static ResultModel error(){
        return new ResultModel(Result.ERROR.getCode(),Result.ERROR.getMsg());
    }

    public static ResultModel error(Integer status,String massage){
        return new ResultModel(status,massage);
    }


}
