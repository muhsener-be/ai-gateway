package com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list;

import lombok.Builder;
import org.springframework.data.domain.Pageable;

@Builder(toBuilder = true)
public record ListPromptTemplateQuery(Pageable pageable) {
}
