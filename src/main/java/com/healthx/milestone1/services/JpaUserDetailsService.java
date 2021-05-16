/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.services;

import com.healthx.milestone1.models.CustomUserDetails;
import com.healthx.milestone1.models.User;
import com.healthx.milestone1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * @author jose
 */

@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> s = () -> new UsernameNotFoundException("Problem during authentication!");
        User u = repository.findUserByUsername(username).orElseThrow(s);
        return new CustomUserDetails(u);
    }
}
