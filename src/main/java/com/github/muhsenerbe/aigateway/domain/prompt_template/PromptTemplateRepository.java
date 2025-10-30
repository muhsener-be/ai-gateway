package com.github.muhsenerbe.aigateway.domain.prompt_template;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PromptTemplateRepository extends JpaRepository<PromptTemplate, UUID> {

    @Query("SELECT pt FROM PromptTemplate pt WHERE  pt.id = :id")
    @NotNull Optional<PromptTemplate> findById(@NotNull UUID id);


    boolean existsBySlug(String slug);


}
