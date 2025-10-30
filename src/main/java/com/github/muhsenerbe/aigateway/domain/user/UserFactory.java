package com.github.muhsenerbe.aigateway.domain.user;

import com.github.muhsenerbe.aigateway.domain.shared.IllegalObjectException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserFactory {
    private static final int PASSWORD_MIN_LENGTH = 5;
    private static final int PASSWORD_MAX_LENGTH = 50;
    private final PasswordEncoder passwordEncoder;

    public User create(String username, String password) {
        String encryptedPassword = Optional.ofNullable(password)
                .map(String::trim)
                .map(trimmed -> {
                    if (trimmed.length() < PASSWORD_MIN_LENGTH || trimmed.length() > PASSWORD_MAX_LENGTH) {
                        throw new IllegalObjectException("Password must be between %d and %d characters long.".formatted(PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH));
                    }
                    return trimmed;
                })
                .map(passwordEncoder::encode)
                .orElseThrow(() -> new IllegalObjectException("Password cannot be null!"));


        return User.builder()
                .username(username)
                .password(encryptedPassword)
                .build();
    }
}
