package com.tosken.rest.service;

import com.google.common.collect.ImmutableList;
import com.tosken.rest.persistence.dao.UserRepository;
import com.tosken.rest.persistence.model.User;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = UserService.class)
class UserServiceTest {

    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserService userService;


    @Test
    public void shouldFindAllUsers() {
        when(userRepository.findAll(any(Sort.class))).thenReturn(ImmutableList.of());

        final List<User> users = userService.getAll();
        assertThat(users, Matchers.emptyCollectionOf(User.class));
    }

}