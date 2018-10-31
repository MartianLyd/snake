package com.kryocore.snake.web.controller;

import com.kryocore.snake.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value="/showUser/{id}" ,method = RequestMethod.GET)
    public String selectUser(@PathVariable Long id){
        return userService.selectUser(id).toString();
    }

}
