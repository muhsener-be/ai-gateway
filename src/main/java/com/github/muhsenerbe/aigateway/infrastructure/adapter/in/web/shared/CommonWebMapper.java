package com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.shared;

import com.github.muhsenerbe.aigateway.application.mapper.shared.VoMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = VoMapper.class)
public interface CommonWebMapper {
}
