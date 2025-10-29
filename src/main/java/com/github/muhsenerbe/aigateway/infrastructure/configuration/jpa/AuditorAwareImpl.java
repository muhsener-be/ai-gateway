package com.github.muhsenerbe.aigateway.infrastructure.configuration.jpa;

import com.github.muhsenerbe.aigateway.infrastructure.configuration.security.principal.SecurityPrincipal;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class AuditorAwareImpl implements AuditorAware<UUID> {
    private static final UUID SYSTEM_USER_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    @Override
    public Optional<UUID> getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication == null || !authentication.isAuthenticated() || authentication instanceof AnonymousAuthenticationToken)
            return Optional.of(SYSTEM_USER_ID);

        SecurityPrincipal principal = (SecurityPrincipal) authentication.getPrincipal();

        return Optional.ofNullable(principal.getId());

    }
}
