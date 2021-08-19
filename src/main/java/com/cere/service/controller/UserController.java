package com.cere.service.controller;

import com.cere.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CheRevir on 2021/7/21
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final UserRepository mUserRepository;

    @Autowired
    public UserController(UserRepository repository) {
        this.mUserRepository = repository;
    }

    @GetMapping
    public String get(){
        return "user";
    }
}
