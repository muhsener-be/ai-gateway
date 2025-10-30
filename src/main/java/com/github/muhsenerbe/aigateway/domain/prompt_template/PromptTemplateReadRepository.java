package com.github.muhsenerbe.aigateway.domain.prompt_template;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PromptTemplateReadRepository extends JpaRepository<PromptTemplate, UUID> {


    Page<PromptTemplateSummaryProjection> findAllSummaries(Pageable pageable);
}
