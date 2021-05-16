/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.repositories;

import com.healthx.milestone1.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author jose
 */

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findUserByUsername(String u);
}
