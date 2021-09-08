package com.cere.service.model;

import com.cere.service.Constants;

/**
 * Created by CheRevir on 2021/8/26
 */
public interface ResponseBuilder<T> {
    Response<T> toResponse();

    static <T> Response<T> empty() {
        return empty(Constants.RESPONSE_CODE_NONE, Constants.RESPONSE_MSG_NONE, null);
    }

    static <T> Response<T> empty(int code, T data) {
        return empty(code, Constants.RESPONSE_MSG_NONE, data);
    }

    static <T> Response<T> empty(String msg, T data) {
        return empty(Constants.RESPONSE_CODE_NONE, msg, data);
    }

    static <T> Response<T> empty(int code, String msg, T data) {
        Response<T> response = new Response<>();
        response.setSuccess(false);
        response.setCode(code);
        response.setMsg(msg);
        response.setData(data);
        return response;
    }
}
