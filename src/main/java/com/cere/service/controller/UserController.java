package com.cere.service.controller;

import com.cere.service.entity.User;
import com.cere.service.model.Response;
import com.cere.service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

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
    public Mono<Response<User>> get(@RequestParam long id) {
        return Response.check(mUserRepository.findById(id).map(User::toResponse));
    }
}
