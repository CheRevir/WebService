package com.cere.service.controller;

import com.cere.service.Constants;
import com.cere.service.entity.Login;
import com.cere.service.model.Response;
import com.cere.service.model.ResponseBuilder;
import com.cere.service.repository.UserRepository;
import com.cere.service.utils.TextUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * Created by CheRevir on 2021/8/27
 */
@RestController
@RequestMapping(value = "/login")
public class LoginController {
    private final Log mLog = LogFactory.getLog(LoginController.class);
    private final UserRepository mUserRepository;

    public LoginController(UserRepository repository) {
        this.mUserRepository = repository;
    }

    @PostMapping()
    public Mono<Response<Object>> login(@RequestBody Login login) {
        mLog.error(login);
        if (TextUtils.isEmpty(login.getAccount()) || TextUtils.isEmpty(login.getPassword())) {
            return Mono.just(new Response<>(false, Constants.RESPONSE_CODE_NONE, String.format("%s为空", "账户或密码")));
        }
        return mUserRepository
                .findAll()
                .filter(user -> login.getAccount().equals(String.valueOf(user.getAccount())) || login.getAccount().equals(user.getName()))
                .singleOrEmpty()
                .map(user -> {
                    mLog.error(user);
                    if (login.getPassword().equals(user.getPassword())) {
                        return new Response<>(true, Constants.RESPONSE_MSG_LOGIN_SUCCESS);
                    }
                    return ResponseBuilder.empty("账号或密码错误");
                })
                .switchIfEmpty(Mono.just(ResponseBuilder.empty("账号或密码错误")))
                .doOnError(mLog::error);
    }
}
