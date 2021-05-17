/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.models;

import java.util.List;

/**
 * @author jose
 */

public class UserDTO {
    private String username;
    private String password;
    private List<String> authorities;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }
}
