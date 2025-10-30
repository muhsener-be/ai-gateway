package com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.api.prompt_template;

import com.github.muhsenerbe.aigateway.application.mapper.shared.VoMapper;
import com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.shared.CommonWebMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {CommonWebMapper.class, VoMapper.class})
public interface PromptTemplateRestMapper {
}
