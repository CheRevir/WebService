package com.cere.service.controller;

import com.cere.service.annotation.CheckToken;
import com.cere.service.entity.User;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by CheRevir on 2021/7/23
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {
    Logger mLogger = LoggerFactory.getLogger(IndexController.class);

    @GetMapping()
    @CheckToken
    public Mono<User> get(@RequestBody User user){
        mLogger.error(user.toString());
        LogFactory.getLog(IndexController.class).error(user);
        return Mono.just(user);
    }
}
