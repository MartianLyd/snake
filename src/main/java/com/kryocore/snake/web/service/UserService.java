package com.kryocore.snake.web.service;

import com.kryocore.snake.web.mapper.UserMapper;
import com.kryocore.snake.web.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public Person selectUser(Long id){
        return userMapper.findByPersonId(id);
    }
}
