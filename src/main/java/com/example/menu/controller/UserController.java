package com.example.menu.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.menu.user.User;
import com.example.menu.user.UserRepository;
import com.example.menu.user.UserRequestDTO;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public String saveUser(@RequestBody UserRequestDTO data) {
        User user = new User(data);

        User saveUser = userRepository.save(user);
        return saveUser.getId();
    }


}