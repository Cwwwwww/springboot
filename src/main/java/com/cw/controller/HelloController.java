package com.cw.controller;

import com.cw.config.ProConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping({"/hello","/hi"})
    public String say() {
        return "Hello Spring Boot";
    }

    @Autowired
    private ProConfig config;

    @GetMapping("/inf")
    public String inf() {
        return config.toString();
    }
}
