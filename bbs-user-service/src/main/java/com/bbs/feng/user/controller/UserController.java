package com.bbs.feng.user.controller;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.user.entity.UserEntity;
import com.bbs.feng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/19 15:59
 * @since JDK 1.8
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    @ResponseBody
    public ResultModel saveVideo(@RequestBody UserEntity user){
        UserEntity users = userService.saveUser(user);
        return ResultModel.ok(users);
    }

}
