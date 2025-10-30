package com.github.muhsenerbe.aigateway.application.exception.shared;

import lombok.Getter;

@Getter
public abstract class ResourceNotFoundException extends ApplicationException {
    private final String resourceName;
    private final String searchKey;
    private final Object searchValue;


    public ResourceNotFoundException(String resourceName, String searchKey, Object searchValue) {
        this(resourceName, searchKey, searchValue, null);
    }

    public ResourceNotFoundException(String resourceName, String searchKey, Object searchValue, Throwable cause) {
        super("%s not found with provided %s: %s".formatted(resourceName, searchKey, searchValue), cause);
        this.resourceName = resourceName;
        this.searchKey = searchKey;
        this.searchValue = searchValue;
    }
}
