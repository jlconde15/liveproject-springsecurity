/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.models;

/**
 * @author jose
 */

public class ClientDto {

    private String clientID;
    private String secret;
    private String scopes;
    private String grantTypes;

    public String getClientID() {
        return clientID;
    }

    public void setClientID(String clientID) {
        this.clientID = clientID;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getScopes() {
        return scopes;
    }

    public void setScopes(String scopes) {
        this.scopes = scopes;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

}
