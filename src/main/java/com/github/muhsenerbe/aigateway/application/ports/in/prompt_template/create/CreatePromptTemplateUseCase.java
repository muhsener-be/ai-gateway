package com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create;

import org.jetbrains.annotations.NotNull;

public interface CreatePromptTemplateUseCase {

    PromptTemplateCreationResponse handle(@NotNull CreatePromptTemplateCommand command);
}
