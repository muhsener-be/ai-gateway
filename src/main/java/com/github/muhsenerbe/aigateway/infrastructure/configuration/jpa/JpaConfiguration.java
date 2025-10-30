package com.github.muhsenerbe.aigateway.infrastructure.configuration.jpa;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
@Configuration
public class JpaConfiguration {
}
