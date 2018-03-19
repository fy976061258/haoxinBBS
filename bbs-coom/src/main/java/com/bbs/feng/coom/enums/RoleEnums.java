package com.bbs.feng.coom.enums;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 13:58
 * @since JDK 1.8
 */
public enum RoleEnums {
    ZCHY(0,"注册会员",10L),
    HJHY(1,"黄金会员",30L),
    BJHY(2,"白金会员",50L),
    ZSHY(3,"钻石会员",100L),
    BKGLY(4,"板块管理员",0L),
    GLY(5,"全局管理员",10000L);

    private Integer code;
    private String name;
    private Long money;

    RoleEnums(Integer code,String name,Long money) {
        this.code = code;
        this.name = name;
        this.money = money;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
