package com.github.muhsenerbe.aigateway.application.usecase.prompt_template.list;

import com.github.muhsenerbe.aigateway.application.exception.shared.SystemException;
import com.github.muhsenerbe.aigateway.application.mapper.prompt_template.PromptTemplateMapper;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list.ListPromptTemplateQuery;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list.ListPromptTemplatesUseCase;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list.PromptTemplateSummary;
import com.github.muhsenerbe.aigateway.application.usecase.shared.UseCase;
import com.github.muhsenerbe.aigateway.domain.prompt_template.PromptTemplateReadRepository;
import com.github.muhsenerbe.aigateway.domain.prompt_template.PromptTemplateSummaryProjection;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@UseCase
@RequiredArgsConstructor
public class ListPromptTemplatesQueryHandler implements ListPromptTemplatesUseCase {

    private final PromptTemplateMapper mapper;
    private final PromptTemplateReadRepository repository;

    @Override
    @Transactional
    public Page<PromptTemplateSummary> handle(@NotNull ListPromptTemplateQuery query) {
        try {
            Page<PromptTemplateSummaryProjection> pageResult = repository.findAllBy(query.pageable());

            List<PromptTemplateSummary> summaries = mapper.toSummaries(pageResult.getContent());

            return new PageImpl<>(summaries, pageResult.getPageable(), pageResult.getTotalElements());

        } catch (Exception e) {
            throw new SystemException("Unexpected error happened during listing prompt-templates: " + e.getMessage(), e);
        }

    }
}
