package com.cere.service;

import com.cere.service.annotation.CheckToken;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.reactive.result.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

/**
 * Created by CheRevir on 2021/8/19
 */
@Component
@Order(2)
public class AuthFilter implements WebFilter {
    private final Logger mLogger = LoggerFactory.getLogger(AuthFilter.class);
    private final Log mLog = LogFactory.getLog(AuthFilter.class);
    private final RequestMappingHandlerMapping mHandlerMapping;

    public AuthFilter(RequestMappingHandlerMapping mHandlerMapping) {
        this.mHandlerMapping = mHandlerMapping;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
       /* ServerHttpRequest request = exchange.getRequest();
        String token = request.getHeaders().getFirst("token");
        mLogger.error(token);
        if (token == null) {
            ServerHttpRequest errRequest = request.mutate().path("/result/token").build();
            return chain.filter(exchange.mutate().request(errRequest).build());
        }

        return chain.filter(exchange);*/
        mLog.error("ad");
        return mHandlerMapping.getHandler(exchange).switchIfEmpty(chain.filter(exchange)).flatMap(it -> {
            mLog.error(it);
            if (it instanceof HandlerMethod) {
                HandlerMethod handlerMethod = (HandlerMethod) it;
                mLog.error(handlerMethod);
                if (handlerMethod.getMethod().getAnnotation(CheckToken.class) != null
                        || handlerMethod.getBeanType().getAnnotation(CheckToken.class) != null) {
                    String token = exchange.getRequest().getHeaders().getFirst("token");
                    mLog.error(token);
                    ServerHttpRequest request =
                            exchange.getRequest().mutate().method(HttpMethod.GET).path("/user").build();
                    return chain.filter(exchange.mutate().request(request).build());
                }
            }
            return chain.filter(exchange);
        });
    }
}
