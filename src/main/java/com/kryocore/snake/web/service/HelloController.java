package com.kryocore.snake.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    private String index(){
        return userService.selectUser(1L).toString();
    }

}
