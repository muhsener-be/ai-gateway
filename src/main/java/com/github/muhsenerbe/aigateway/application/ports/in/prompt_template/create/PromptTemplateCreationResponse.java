package com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record PromptTemplateCreationResponse(UUID id) {
}
