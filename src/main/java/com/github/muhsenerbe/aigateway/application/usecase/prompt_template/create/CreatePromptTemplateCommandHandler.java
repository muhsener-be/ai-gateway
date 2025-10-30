package com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create;

import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create.CreatePromptTemplateUseCase;
import com.github.muhsenerbe.aigateway.application.usecase.shared.UseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class CreatePromptTemplateCommandHandler implements CreatePromptTemplateUseCase {


    @Override
    @Transactional
    public PromptTemplateCreationResponse handle(CreatePromptTemplateCommand command) {
        return null;
    }
}
