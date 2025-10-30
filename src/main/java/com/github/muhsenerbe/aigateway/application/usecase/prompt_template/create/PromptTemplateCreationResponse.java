package com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create;

import lombok.Builder;

import java.util.UUID;

@Builder(toBuilder = true)
public record PromptTemplateCreationResponse(UUID id) {
}
