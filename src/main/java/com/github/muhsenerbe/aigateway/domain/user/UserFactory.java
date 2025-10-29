package com.github.muhsenerbe.aigateway.domain.user;

public class UserFactory {

    public User create(String username, String password) {
        // TODO: encrypt password, and validate its length
        return User.builder()
                .username(username)
                .password(password)
                .build();
    }
}
