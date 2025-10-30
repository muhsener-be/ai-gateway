package com.github.muhsenerbe.aigateway.domain.prompt_template;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PromptTemplateReadRepository extends JpaRepository<PromptTemplate, UUID> {


    Page<PromptTemplateSummaryProjection> findAllSummaries(Pageable pageable);
}
