package com.bbs.feng.coom.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/06/26 22:37
 * @since JDK 1.8
 */
public class GsonUtil {
    public static <T>T fromJson(String json,Class<T> type){
        Gson gson = new Gson();
        return gson.fromJson(json,type);

    }

    public static <T> List<T> listFromJson(String json,Type type){
        Gson gson = new Gson();
        return gson.fromJson(json, type);
    }

    public static String objfromBeen(Object object){
        Gson gson = new Gson();
        return gson.toJson(object);
    }

}
