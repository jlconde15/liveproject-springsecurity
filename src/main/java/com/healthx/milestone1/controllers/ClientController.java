/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.controllers;

import com.healthx.milestone1.models.Client;
import com.healthx.milestone1.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.oauth2.provider.ClientAlreadyExistsException;
import org.springframework.web.bind.annotation.*;

/**
 * @author jose
 */
@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client register(@RequestBody Client client) {

        if (repository.findClientByClientId(client.getClientId()).isPresent()){
            throw new ClientAlreadyExistsException("The client already exists");
        }
        else {
            client.getGrantTypes().forEach(gt -> gt.setClient(client));
            return repository.save(client);
        }
    }

}
