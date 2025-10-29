package com.github.muhsenerbe.aigateway.infrastructure.testcontainers;

import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.List;

@Configuration
@Profile("dev")
public class DevTestContainersConfiguration {


    @SuppressWarnings("resource")
    @ServiceConnection
    @Bean
    public PostgreSQLContainer<?> postgreSQLContainer() {
        PostgreSQLContainer<?> container = new PostgreSQLContainer<>("postgres:17")
                .withDatabaseName("devdb")
                .withUsername("devdb")
                .withPassword("devdb");
        container.setPortBindings(List.of("5432:5432"));
        return container;
    }
}
