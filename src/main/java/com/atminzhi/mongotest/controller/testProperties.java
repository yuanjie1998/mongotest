package com.atminzhi.mongotest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class testProperties {
    @Value("${boot.name}")
    private String name;
    @Value("${boot.age}")
    private Integer age;

    @GetMapping("/test01")
    public String test01(){
        return name+"====="+age;
    }
}
