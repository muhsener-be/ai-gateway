package com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create;

import com.github.muhsenerbe.aigateway.application.exception.prompt_template.DuplicatePromptTemplateException;
import com.github.muhsenerbe.aigateway.application.exception.shared.BusinessValidationException;
import com.github.muhsenerbe.aigateway.application.exception.shared.SystemException;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create.CreatePromptTemplateUseCase;
import com.github.muhsenerbe.aigateway.application.usecase.shared.UseCase;
import com.github.muhsenerbe.aigateway.domain.prompt_template.PromptTemplate;
import com.github.muhsenerbe.aigateway.domain.prompt_template.PromptTemplateFactory;
import com.github.muhsenerbe.aigateway.domain.prompt_template.PromptTemplateRepository;
import com.github.muhsenerbe.aigateway.domain.shared.IllegalObjectException;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
public class CreatePromptTemplateCommandHandler implements CreatePromptTemplateUseCase {

    private final PromptTemplateRepository repository;
    private final PromptTemplateFactory factory;

    @Override
    @Transactional
    public PromptTemplateCreationResponse handle(@NotNull CreatePromptTemplateCommand command) {
        try {
            String slug = command.slug();
            boolean exists = repository.existsBySlug(slug);
            if (exists)
                throw new DuplicatePromptTemplateException(slug);

            PromptTemplate newTemplate = factory.create(slug, command.goal(), command.sourceReference(), command.ethicalConsiderations());
            PromptTemplate saved = repository.saveAndFlush(newTemplate);


            return new PromptTemplateCreationResponse(saved.getId());

        } catch (IllegalObjectException e) {
            throw new BusinessValidationException(e.getMessage(), e);
        } catch (DuplicatePromptTemplateException e) {
            throw e;
        } catch (Exception e) {
            throw new SystemException("Unexpected error happened during create prompt-template: " + e.getMessage(), e);
        }
    }
}
