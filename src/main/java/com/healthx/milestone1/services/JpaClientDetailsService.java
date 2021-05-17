/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.services;

import com.healthx.milestone1.models.Client;
import com.healthx.milestone1.models.CustomClientDetails;
import com.healthx.milestone1.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author jose
 */
@Service
public class JpaClientDetailsService implements ClientDetailsService {

    private final ClientRepository repository;

    public JpaClientDetailsService(ClientRepository repository) {
        this.repository = repository;
    }

    @Override
    public CustomClientDetails loadClientByClientId(String clientId) throws ClientRegistrationException {
        Optional<Client> client = repository.findClientByClientId(clientId);
        return client.map(CustomClientDetails::new).orElseThrow(()-> new ClientRegistrationException("Client doesn't exist!"));
    }
}
