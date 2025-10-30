package com.github.muhsenerbe.aigateway.domain.user;

import com.github.muhsenerbe.aigateway.support.data.TestData;

import java.util.UUID;

public class UserTestBuilder {

    private UUID id;
    private String username;
    private String password;
    private boolean isActive;


    private UserTestBuilder() {
        id = UUID.randomUUID();
        username = TestData.username();
        password = TestData.randomText();
        isActive = true;
    }

    public static UserTestBuilder aUser() {
        return new UserTestBuilder();
    }

    public static UserTestBuilder from(User user) {
        return aUser()
                .withId(user.getId())
                .withPassword(user.getPassword())
                .withUsername(user.getUsername())
                .withIsActive(user.isActive());
    }


    public UserTestBuilder withId(UUID val) {
        this.id = val;
        return this;
    }

    public UserTestBuilder withUsername(String val) {
        this.username = val;
        return this;
    }

    public UserTestBuilder withPassword(String val) {
        this.password = val;
        return this;
    }

    public UserTestBuilder withIsActive(boolean val) {
        this.isActive = val;
        return this;
    }


    public User build() {
        return new User(id, username, password, isActive);
    }

}