package com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.mvc.prompt_template;

import com.github.muhsenerbe.aigateway.application.mapper.shared.VoMapper;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create.CreatePromptTemplateCommand;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {VoMapper.class})
public interface PromptTemplateWebMapper {


    CreatePromptTemplateCommand toCreateCommand(CreateTemplateForm form);
}
