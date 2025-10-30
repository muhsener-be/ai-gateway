package com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.net.URI;
import java.time.Instant;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
@Getter
public class PromptTemplateSummary {

    private UUID id;
    private String slug;
    private String goal;
    private URI sourceReference;
    private String ethnicalConsiderations;

    private UUID createdBy;
    private UUID updatedBy;
    private Instant createdAt;
    private Instant updatedAt;
}
