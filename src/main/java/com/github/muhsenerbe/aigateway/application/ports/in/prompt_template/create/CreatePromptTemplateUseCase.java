package com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create;

import com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create.CreatePromptTemplateCommand;
import com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create.PromptTemplateCreationResponse;
import org.jetbrains.annotations.NotNull;

public interface CreatePromptTemplateUseCase {

    PromptTemplateCreationResponse handle(@NotNull CreatePromptTemplateCommand command);
}
