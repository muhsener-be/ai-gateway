package com.github.muhsenerbe.aigateway.application.mapper.prompt_template;

import com.github.muhsenerbe.aigateway.application.mapper.shared.VoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {VoMapper.class})
public interface PromptTemplateMapper {
}
