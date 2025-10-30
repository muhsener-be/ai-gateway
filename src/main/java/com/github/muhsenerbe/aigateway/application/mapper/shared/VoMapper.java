package com.github.muhsenerbe.aigateway.application.mapper.shared;

import org.mapstruct.Mapper;

import java.net.URI;

@Mapper(componentModel = "spring")
public interface VoMapper {


    default URI toURI(String value) {
        return value == null ? null : URI.create(value);
    }

    default String fromURI(URI uri) {
        return uri == null ? null : uri.toString();
    }
}
