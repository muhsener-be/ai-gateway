package com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list;

import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;

public interface ListPromptTemplatesUseCase {

    Page<PromptTemplateSummary> handle(@NotNull ListPromptTemplateQuery query);
}
