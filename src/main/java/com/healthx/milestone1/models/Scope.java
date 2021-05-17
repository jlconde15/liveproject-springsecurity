/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.models;

import javax.persistence.*;

/**
 * @author jose
 */

@Entity
public class Scope {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @JoinColumn(name = "client")
    @ManyToOne
    private Client client;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
