package com.github.muhsenerbe.aigateway.application.exception.shared;

import lombok.Getter;

import java.util.Map;

@Getter
public abstract class DuplicateException extends ApplicationException {
    private final String resource;
    private final Map<String, String> details;

    public DuplicateException(String resource, Map<String, String> details) {
        this(resource, details, null);
    }

    public DuplicateException(String resource, Map<String, String> details, Throwable cause) {
        super("Duplicated %s with details: %s".formatted(resource, details), cause);
        this.resource = resource;
        this.details = details;
    }

}
