package com.bbs.feng.coom.result.status;


/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/10 20:42
 * @since JDK 1.8
 */
public enum Result {
    SUCCESS(200,"成功"),
    ERROR(500,"服务器暂时无法响应，青稍后再试");


    private Integer code;

    private String msg;

    Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
