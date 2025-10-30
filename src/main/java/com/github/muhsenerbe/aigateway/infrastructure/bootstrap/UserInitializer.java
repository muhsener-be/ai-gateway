package com.github.muhsenerbe.aigateway.infrastructure.bootstrap;

import com.github.muhsenerbe.aigateway.domain.user.User;
import com.github.muhsenerbe.aigateway.domain.user.UserFactory;
import com.github.muhsenerbe.aigateway.domain.user.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class UserInitializer {

    private final UserRepository repository;
    private final BootstrapUserDetails details;
    private final UserFactory userFactory;

    @PostConstruct
    public void initializeUser() {
        try {
            String username = details.getUsername();
            String password = details.getPassword();
            User user = userFactory.create(username, password);

            if (!repository.existsByUsername(username)) {
                repository.save(user);
                log.info("User: '{}' persisted into database.", username);
            } else
                log.warn("User '{}' already exists in database.", username);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to initialize bootstrap user due to: %s".formatted(e.getMessage()), e);
        }
    }
}
