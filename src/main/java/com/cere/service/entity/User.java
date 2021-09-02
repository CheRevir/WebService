package com.cere.service.entity;

import com.cere.service.model.Response;
import com.cere.service.model.ResponseBuilder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Created by CheRevir on 2021/7/21
 */
@Data
@Table("user")
public class User implements ResponseBuilder<User> {
    @Id
    private long id;
    private long account;
    private String name;
    private String password;
    private int type;

    @Override
    public Response<User> toResponse() {
        Response<User> response = new Response<>();
        response.setSuccess(true);
        response.setData(this);
        return response;
    }
}
