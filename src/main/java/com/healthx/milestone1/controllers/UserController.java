/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.controllers;

import com.healthx.milestone1.models.User;
import com.healthx.milestone1.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author jose
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        user.getAuthorities().forEach(a -> a.setUser(user));
        return repository.save(user);
    }

}
