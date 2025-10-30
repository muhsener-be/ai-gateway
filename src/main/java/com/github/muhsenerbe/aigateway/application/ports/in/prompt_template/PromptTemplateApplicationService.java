package com.github.muhsenerbe.aigateway.application.ports.in.prompt_template;

import com.github.muhsenerbe.aigateway.application.exception.prompt_template.DuplicatePromptTemplateException;
import com.github.muhsenerbe.aigateway.application.exception.shared.BusinessValidationException;
import com.github.muhsenerbe.aigateway.application.exception.shared.SystemException;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create.CreatePromptTemplateCommand;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create.PromptTemplateCreationResponse;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list.ListPromptTemplateQuery;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list.PromptTemplateSummary;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;

public interface PromptTemplateApplicationService {


    PromptTemplateCreationResponse create(@NotNull CreatePromptTemplateCommand command) throws BusinessValidationException, SystemException, DuplicatePromptTemplateException;

    Page<PromptTemplateSummary> list(@NotNull ListPromptTemplateQuery query) throws SystemException;
}
