package com.tosken.rest.persistence.model;

import java.time.LocalDateTime;

public final class UserMother {
    private UserMother() {
    }

    public static User.UserBuilder complete() {
        return new User.UserBuilder()
                .email("test@test.de")
                .firstname("John")
                .lastname("Doe")
                .registerDate(LocalDateTime.now());
    }
}
