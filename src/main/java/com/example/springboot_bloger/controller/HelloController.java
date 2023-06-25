package com.example.springboot_bloger.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // 测试信息
    @RequestMapping("/")
    public String Hello(){
        return "api-article";
    }
}
