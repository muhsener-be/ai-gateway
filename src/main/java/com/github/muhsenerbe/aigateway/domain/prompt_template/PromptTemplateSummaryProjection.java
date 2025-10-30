package com.github.muhsenerbe.aigateway.domain.prompt_template;

import java.net.URI;
import java.time.Instant;
import java.util.UUID;

public interface PromptTemplateSummaryProjection {

    UUID getId();

    String getSlug();

    String getGoal();

    URI getSourceReference();

    String getEthicalConsiderations();

    Instant getCreatedAt();

    Instant getUpdatedAt();

    UUID getCreatedBy();

    UUID getUpdatedBy();

}
