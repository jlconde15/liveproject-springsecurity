/*
 * Copyright (C) 2021 Aptly GmbH
 */

package com.healthx.milestone1.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * @author jose
 */

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
    private final AuthenticationManager authenticationManager;

    private final TokenStore tokenStore;

    private final JwtAccessTokenConverter converter;

    public AuthorizationServerConfig(AuthenticationManager authenticationManager,
                                            TokenStore tokenStore,
                                            JwtAccessTokenConverter converter) {
        this.authenticationManager = authenticationManager;
        this.tokenStore = tokenStore;
        this.converter = converter;
    }

    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager)
                .tokenStore(tokenStore)
                .accessTokenConverter(converter);
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("client")
                .secret("secret")
                .authorizedGrantTypes("authorization_code", "password", "refresh_token")
                .scopes("read");
    }
}