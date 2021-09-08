package com.cere.service.controller;

import com.cere.service.entity.Login;
import com.cere.service.model.Response;
import com.cere.service.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by CheRevir on 2021/9/2
 */
@RestController
@RequestMapping(value = "/register")
public class RegisterController {
    private final UserRepository mUserRepository;

    public RegisterController(UserRepository userRepository) {
        this.mUserRepository = userRepository;
    }

    @PostMapping
    public Mono<Response<Object>> register(@RequestBody Login login) {

        return null;
    }
}
