package com.criown.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/hello1")
    public String hello1(){
        System.out.println(1);
        return "Hello,World";
    }

}
