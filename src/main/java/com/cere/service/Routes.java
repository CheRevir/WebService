package com.cere.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * Created by CheRevir on 2021/8/19
 */
@Configuration
public class Routes {

    @Bean
    RouterFunction<ServerResponse> login() {
        return RouterFunctions.route(RequestPredicates.GET("/home"),
                request -> ServerResponse.ok().body(BodyInserters.fromValue("Home")));
    }
}
