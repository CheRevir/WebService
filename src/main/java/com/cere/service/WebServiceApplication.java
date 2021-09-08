package com.cere.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebServiceApplication {
    private static final Log mLog = LogFactory.getLog(WebServiceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WebServiceApplication.class, args);
    }

}
