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

    private Long count;

    private Object body;


    public ResultModel(Object body , Integer status , String massage , Long count){
        this.status = status;
        this.body = body;
        this.massage = massage;
        this.count = count;
    }

    public static ResultModel ok(Object body,Long count){
        return new ResultModel(body, Result.SUCCESS.getCode(),Result.SUCCESS.getMsg(),count);
    }


}
