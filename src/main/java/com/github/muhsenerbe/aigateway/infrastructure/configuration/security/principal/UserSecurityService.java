package com.github.muhsenerbe.aigateway.infrastructure.configuration.security.principal;

import com.github.muhsenerbe.aigateway.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {
    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(myUser -> {
                    return SecurityPrincipal.builder()
                            .id(myUser.getId())
                            .username(myUser.getUsername())
                            .password(myUser.getPassword())
                            .isActive(myUser.isActive())
                            .build();
                })
                .orElseThrow(() -> new UsernameNotFoundException("Bad credentials."));
    }
}
