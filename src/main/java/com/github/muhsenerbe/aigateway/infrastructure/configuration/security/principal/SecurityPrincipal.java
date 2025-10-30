package com.github.muhsenerbe.aigateway.infrastructure.configuration.security.principal;

import lombok.Builder;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class SecurityPrincipal implements UserDetails {

    @Getter
    private final UUID id;
    private final String username;
    private final String password;
    private final boolean isActive;

    @Builder(toBuilder = true)
    public SecurityPrincipal(@NotNull UUID id, @NotNull String username, @Nullable String password, boolean isActive) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.isActive = isActive;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
