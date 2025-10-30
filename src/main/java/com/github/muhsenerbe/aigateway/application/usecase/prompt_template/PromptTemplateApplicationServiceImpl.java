package com.github.muhsenerbe.aigateway.application.usecase.prompt_template;

import com.github.muhsenerbe.aigateway.application.exception.shared.BusinessValidationException;
import com.github.muhsenerbe.aigateway.application.exception.shared.SystemException;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.PromptTemplateApplicationService;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create.CreatePromptTemplateUseCase;
import com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create.CreatePromptTemplateCommand;
import com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create.PromptTemplateCreationResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PromptTemplateApplicationServiceImpl implements PromptTemplateApplicationService {


    private final CreatePromptTemplateUseCase createPromptTemplateUseCase;

    @Override
    public PromptTemplateCreationResponse create(@NotNull CreatePromptTemplateCommand command) throws BusinessValidationException, SystemException {
        return createPromptTemplateUseCase.handle(command);
    }
}
