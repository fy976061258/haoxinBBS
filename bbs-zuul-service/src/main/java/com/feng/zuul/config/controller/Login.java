package com.feng.zuul.config.controller;

import com.bbs.feng.coom.result.ResultModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/06/26 00:12
 * @since JDK 1.8
 */
@Controller
@RequestMapping(name = "/login")
public class Login {
    @GetMapping(name = "/login")
    public ResultModel login(){

        return ResultModel.ok("cccccc");
    }
}