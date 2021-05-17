/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.controllers;

import com.healthx.milestone1.models.Authority;
import com.healthx.milestone1.models.User;
import com.healthx.milestone1.models.UserDTO;
import com.healthx.milestone1.repositories.AuthorityRepository;
import com.healthx.milestone1.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author jose
 */

@RestController
@RequestMapping("/users")
public class UserController {

    private UserRepository userRepository;
    private AuthorityRepository authorityRepository;

    public UserController(UserRepository userRepository, AuthorityRepository authorityRepository) {
        this.userRepository = userRepository;
        this.authorityRepository = authorityRepository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO addUser(@RequestBody UserDTO userDTO){
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        User userSaved = userRepository.save(user);
        Authority authority = new Authority();
        authority.setName(userDTO.getAuthorities().get(0));
        authority.setUser(userSaved);
        Authority authoritySaved = authorityRepository.save(authority);

        return userDTO;
    }

}
