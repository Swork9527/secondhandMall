package com.hzf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hello")
public class IndexController {
    @GetMapping("/{path}")
    public String index(@PathVariable("path") String path){
//        通过thymeleaf跳转到path与application.yml中定义的prefix和suffix拼接而成的地址上
        System.out.println(path);
        return path;
    }
}
