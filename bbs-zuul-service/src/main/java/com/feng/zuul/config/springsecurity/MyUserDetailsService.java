package com.feng.zuul.config.springsecurity;

import com.bbs.feng.user.entity.UserEntity;
import com.bbs.feng.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

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

        if(user  == null){
            throw new UsernameNotFoundException("用户名："+ username  +  "不存在！");
        }

        Collection<SimpleGrantedAuthority> collection = new HashSet<SimpleGrantedAuthority>();

        collection.add(new SimpleGrantedAuthority(user.getRoles().getName()));

        return new org.springframework.security.core.userdetails.User(username,user.getPassword(),collection);
    }
}
