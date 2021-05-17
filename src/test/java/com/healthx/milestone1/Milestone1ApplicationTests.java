package com.healthx.milestone1;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class Milestone1ApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    @DisplayName("Test access_token is obtained using valid user and client")
    public void testAccessTokenIsObtainedUsingValidUserAndClient() throws Exception {
        mvc.perform(
                post("/oauth/token")
                        .with(httpBasic("myClientId", "mySecret"))
                        .queryParam("grant_type", "password")
                        .queryParam("username", "john")
                        .queryParam("password", "555")
                        .queryParam("scope", "read")
        )
                .andExpect(jsonPath("$.access_token").exists())
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("Register a new client")
    public void testRegisterNewClient() throws Exception {
        mvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"clientID\" : \"myNewClient\",\n" +
                                "    \"secret\" : \"superSecret\",\n" +
                                "    \"scopes\" : \"read\",\n" +
                                "    \"grantTypes\" : \"password\"\n" +
                                "}")
        )
                .andExpect(jsonPath("$.client_id").exists())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("create a new user")
    public void testUserCreation() throws Exception {
        mvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"username\" : \"lukas\",\n" +
                                "    \"password\" : \"99999\",\n" +
                                "    \"authorities\" : [\"WRITE\"]\n" +
                                "}")
        )
                .andExpect(jsonPath("$.username").exists())
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Get access_token using a new client")
    public void testAccessTokenForNewClient() throws Exception {
        mvc.perform(
                post("/oauth/token")
                        .with(httpBasic("aNewClient", "superMegaSecret"))
                        .queryParam("grant_type", "password")
                        .queryParam("username", "john")
                        .queryParam("password", "555")
                        .queryParam("scope", "read")
        )
                .andExpect(status().isUnauthorized());

        mvc.perform(
                post("/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\n" +
                                "    \"clientID\" : \"aNewClient\",\n" +
                                "    \"secret\" : \"superMegaSecret\",\n" +
                                "    \"scopes\" : \"read\",\n" +
                                "    \"grantTypes\" : \"password\"\n" +
                                "}")
        )
                .andExpect(jsonPath("$.client_id").exists())
                .andExpect(status().isCreated());

        mvc.perform(
                post("/oauth/token")
                        .with(httpBasic("aNewClient", "superMegaSecret"))
                        .queryParam("grant_type", "password")
                        .queryParam("username", "john")
                        .queryParam("password", "555")
                        .queryParam("scope", "read")
        )
                .andExpect(jsonPath("$.access_token").exists())
                .andExpect(status().isOk());
    }
}
