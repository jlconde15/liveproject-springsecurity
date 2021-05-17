/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.models;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

/**
 * @author jose
 */

@Entity
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "client_id")
    private String clientId;
    private String secret;
    private String scope;
    @Column(name = "rediect_uri")
    private String rediectUri;
    @OneToMany(mappedBy = "client", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    private List<ClientGrantType> grantTypes;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getRediectUri() {
        return rediectUri;
    }

    public void setRediectUri(String rediectUri) {
        this.rediectUri = rediectUri;
    }

    public List<ClientGrantType> getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(List<ClientGrantType> grantTypes) {
        this.grantTypes = grantTypes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return id == client.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
