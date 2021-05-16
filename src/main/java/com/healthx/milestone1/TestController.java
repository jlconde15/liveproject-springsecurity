/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jose
 */
@RestController
public class TestController {
    @GetMapping("/hello")
    public String test(){
        return "Hello";
    }
}
