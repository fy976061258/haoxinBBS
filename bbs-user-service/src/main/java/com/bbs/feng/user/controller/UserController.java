package com.bbs.feng.user.controller;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.user.entity.UserEntity;
import com.bbs.feng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

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
        if (userService.isUserExist(user)) {
            System.out.println("用户名 " + user.getName() + " 已存在");
            return ResultModel.error(100,HttpStatus.CONFLICT.getReasonPhrase());
        }
        UserEntity users = userService.saveUser(user);
        return ResultModel.ok(users);
    }


    @GetMapping(path = "/find/one")
    @ResponseBody
    public ResultModel findOneUserByAccount(@RequestParam String accountNumber){
        UserEntity userEntity = userService.findOneUserByAccount(accountNumber);
        return ResultModel.ok(userEntity);
    }


}
