package com.tosken.rest.controller;

import com.google.common.collect.ImmutableList;
import com.tosken.rest.configuration.AuthenticationEntryPoint;
import com.tosken.rest.persistence.model.UserMother;
import com.tosken.rest.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = UserController.class)
class UserControllerTest {

    @TestConfiguration
    public static class Config {
        @Bean
        public AuthenticationEntryPoint authenticationEntryPoint() {
            return new AuthenticationEntryPoint();
        }
    }

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getAll() throws Exception {
        when(userService.getAll()).thenReturn(ImmutableList.of(UserMother.complete().build()));

        mockMvc.perform(get("/user")
                .contentType("application/json"))
                .andExpect(status().is4xxClientError());
    }
}
