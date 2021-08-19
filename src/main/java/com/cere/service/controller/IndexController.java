package com.cere.service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by CheRevir on 2021/7/23
 */
@RestController
@RequestMapping(value = "/")
public class IndexController {

    @GetMapping
    public String get(){
        return "index";
    }
}
