package com.bbs.feng.user.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/02/04 18:18
 * @since JDK 1.8
 */
@RestController
public class TestController {

    @Autowired
    private  TestService testService;

    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return  testService.test();
    }
}
