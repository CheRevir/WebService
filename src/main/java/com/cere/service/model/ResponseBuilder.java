package com.cere.service.model;

import com.cere.service.Constants;

/**
 * Created by CheRevir on 2021/8/26
 */
public interface ResponseBuilder<T> {
    Response<T> toResponse();

    static <T> Response<T> empty() {
        return empty(Constants.RESPONSE_CODE_NONE, Constants.RESPONSE_MSG_NONE);
    }

    static <T> Response<T> empty(int code) {
        return empty(code, Constants.RESPONSE_MSG_NONE);
    }

    static <T> Response<T> empty(String msg) {
        return empty(Constants.RESPONSE_CODE_NONE, msg);
    }

    static <T> Response<T> empty(int code, String msg) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setCode(code);
        response.setMsg(msg);
        return response;
    }
}
