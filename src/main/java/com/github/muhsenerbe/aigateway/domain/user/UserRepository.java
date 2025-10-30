package com.github.muhsenerbe.aigateway.domain.user;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {


    @Query("SELECT u FROM User u WHERE u.id = :id")
    @NotNull Optional<User> findById(@NotNull UUID id);


    Optional<User> findByUsername(@NotNull String username);
    boolean existsByUsername(@NotNull String username);
}
