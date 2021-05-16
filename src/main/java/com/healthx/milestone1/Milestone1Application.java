package com.healthx.milestone1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
public class Milestone1Application {

    public static void main(String[] args) {
        SpringApplication.run(Milestone1Application.class, args);
    }

}
