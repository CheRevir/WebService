package com.cere.service.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * Created by CheRevir on 2021/7/21
 */
@Table("user")
public class User {
    @Id
    private long id;
    private long account;
    private String name;

    public long getId() {
        return id;
    }

    public long getAccount() {
        return account;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
