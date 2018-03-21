package com.bbs.feng.ribbon.controller;

import com.bbs.feng.ribbon.service.UserService;
import com.bbs.feng.user.entity.UserEntity;
import com.bbs.feng.video.entity.VideoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 16:02
 * @since JDK 1.8
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/save")
    @ResponseBody
    public Object saveVideo(@RequestBody UserEntity userEntity){
        Object body =  userService.saveUser(userEntity);
        return body;
    }

}
