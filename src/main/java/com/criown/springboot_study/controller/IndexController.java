package com.criown.springboot_study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class IndexController {

    @RequestMapping({"/index", "/"})
    public String index(){
        return "index";
    }

    @RequestMapping("/test")
    public String studyForThymeleaf(Model model){
       model.addAttribute("msg","Hello.SpringBoot");
       model.addAttribute("msgcode","<div>Hello.SpringBoot</div>");
       model.addAttribute("listmsg", Arrays.asList("sty","wl","CRIOWN"));
       return "test_thymeleaf";
    }

}
