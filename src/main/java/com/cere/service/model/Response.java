package com.cere.service.model;

import com.cere.service.Constants;
import reactor.core.publisher.Mono;

/**
 * Created by CheRevir on 2021/8/26
 */
public class Response<T> {
    private boolean success = false;
    private int code = 0;
    private String msg = "";
    private T data;

    public Response() {
    }

    public Response(boolean success) {
        this(success, "");
    }

    public Response(boolean success, T data) {
        this(success, 0, "", data);
    }

    public Response(boolean success, String msg) {
        this(success, 0, msg);
    }

    public Response(boolean success, int code, String msg) {
        this(success, code, msg, null);
    }

    public Response(boolean success, int code, String msg, T data) {
        this.success = success;
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public boolean getSuccess() {
        return this.success;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Response{" +
                "success=" + success +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public static <T> Mono<Response<T>> check(Mono<Response<T>> data) {
        return data.switchIfEmpty(Mono.just(new Response<>(false, Constants.RESPONSE_CODE_NONE,
                Constants.RESPONSE_MSG_NONE)));
    }
}
