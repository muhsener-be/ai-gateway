package com.github.muhsenerbe.aigateway.domain.shared;

public class IllegalObjectException extends DomainException{


    public IllegalObjectException(String message) {
        super(message);
    }

    public IllegalObjectException(String message, Throwable cause) {
        super(message, cause);
    }
}
