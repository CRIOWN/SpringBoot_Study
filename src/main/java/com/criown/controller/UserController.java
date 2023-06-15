package com.criown.controller;

import com.criown.entity.User;
import com.criown.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/mybatis")
    public String selectAll(){
        System.out.println("mybatis");
        List<User> users = userMapper.queryUserList();
        System.out.println(users);
        return "ok";
    }


}
