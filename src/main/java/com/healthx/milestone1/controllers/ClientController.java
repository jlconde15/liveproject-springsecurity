/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.controllers;

import com.healthx.milestone1.models.Client;
import com.healthx.milestone1.models.ClientDto;
import com.healthx.milestone1.repositories.ClientRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author jose
 */
@RestController
@RequestMapping("/register")
public class ClientController {

    private final ClientRepository repository;

    public ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client register(@RequestBody ClientDto clientDto){
        Client client = new Client();
        client.setClient_id(clientDto.getClientID());
        client.setClient_secret(clientDto.getSecret());
        client.setScope(clientDto.getScopes());
        client.setAuthorized_grant_types(clientDto.getGrantTypes());

        return repository.save(client);
    }

}
