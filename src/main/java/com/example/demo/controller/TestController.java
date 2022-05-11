package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName TestController
 * @Description TODO
 * @Author WangZhe
 * @Date 2022/4/14 11:23
 * @Version 1.0
 */

@RestController
public class TestController {

    @GetMapping("/hello")
    public String hello() {
        return "hello spring security";
    }

    @GetMapping("/test/index")
    public String index() {
        return "hello spring security-index";
    }


    @GetMapping("/test/authority")
    public String authority() {
        return "/test/authority";
    }


    @GetMapping("/test/authorities")
    public String authorities() {
        return "/test/authorities";
    }

    @GetMapping("/test/yuancheng")
    public String yuancheng() {
        return "/test/authorities";
    }
}
