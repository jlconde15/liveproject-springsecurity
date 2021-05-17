/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.controllers;

import com.healthx.milestone1.models.User;
import com.healthx.milestone1.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

/**
 * @author jose
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getAuthorities().forEach(a -> a.setUser(user));
        return repository.save(user);
    }

}
