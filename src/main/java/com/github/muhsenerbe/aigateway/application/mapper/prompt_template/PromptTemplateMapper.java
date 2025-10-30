package com.github.muhsenerbe.aigateway.application.mapper.prompt_template;

import com.github.muhsenerbe.aigateway.application.mapper.shared.VoMapper;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list.PromptTemplateSummary;
import com.github.muhsenerbe.aigateway.domain.prompt_template.PromptTemplateSummaryProjection;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {VoMapper.class})
public interface PromptTemplateMapper {


    PromptTemplateSummary toSummary(PromptTemplateSummaryProjection source);

    List<PromptTemplateSummary> toSummaries(List<PromptTemplateSummaryProjection> source);


}
