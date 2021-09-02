package com.cere.service.entity;

import lombok.Data;
import lombok.ToString;

/**
 * Created by CheRevir on 2021/8/27
 */
@Data
@ToString
public class Login {
    private String account;
    private String password;
}
