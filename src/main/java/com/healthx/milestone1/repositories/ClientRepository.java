/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.repositories;

import com.healthx.milestone1.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author jose
 */

public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> findClientByClientId(String clientId);
}
