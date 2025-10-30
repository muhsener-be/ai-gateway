package com.github.muhsenerbe.aigateway.application.ports.in.prompt_template;

import com.github.muhsenerbe.aigateway.application.exception.shared.BusinessValidationException;
import com.github.muhsenerbe.aigateway.application.exception.shared.SystemException;
import com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create.CreatePromptTemplateCommand;
import com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create.PromptTemplateCreationResponse;
import org.jetbrains.annotations.NotNull;

public interface PromptTemplateApplicationService {


    PromptTemplateCreationResponse create(@NotNull CreatePromptTemplateCommand command) throws BusinessValidationException, SystemException;
}
