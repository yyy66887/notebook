package com.baizhi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("hello")
public class HelloController {



    @RequestMapping("hello")
    public String hello(){
        System.out.println("hello ok");
        return "index";
    }
}
