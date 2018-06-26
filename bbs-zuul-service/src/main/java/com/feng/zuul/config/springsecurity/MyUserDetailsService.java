package com.feng.zuul.config.springsecurity;

import com.bbs.feng.coom.result.ResultModel;
import com.bbs.feng.coom.util.GsonUtil;
import com.bbs.feng.coom.util.MapClassUtil;
import com.bbs.feng.user.entity.UserEntity;
import com.feng.zuul.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/**
 * @author Marco.Feng
 * @title: haoxinBBS
 * @description:
 * @date 2018/03/21 10:33
 * @since JDK 1.8
 */
public class MyUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findOneUserByAccount(username);
//        ResultModel resultModel = GsonUtil.fromJson(json,ResultModel.class);

//        Map<String,Object> map = (Map<String, Object>) object;
//        UserEntity user = GsonUtil.fromJson(GsonUtil.objfromBeen(resultModel.getBody()));
        if(user  == null){
            throw new UsernameNotFoundException("用户名："+ username  +  "不存在！");
        }else if (user.getIs_disable() == true){
            throw new UsernameNotFoundException("该用户已被禁用");
        }

        //添加角色
        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();
        collection.add(new SimpleGrantedAuthority(user.getRoles().getName()));

        //用户认证
        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),collection);
    }
}