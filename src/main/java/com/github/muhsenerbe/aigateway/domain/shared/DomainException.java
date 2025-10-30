package com.github.muhsenerbe.aigateway.domain.shared;

public  abstract class DomainException extends RuntimeException {


    public DomainException(String message) {
        super(message);
    }

    public DomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
