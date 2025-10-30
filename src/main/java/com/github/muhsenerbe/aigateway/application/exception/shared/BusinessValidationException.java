package com.github.muhsenerbe.aigateway.application.exception.shared;

public class BusinessValidationException extends ApplicationException {


    public BusinessValidationException(String message) {
        super(message);
    }

    public BusinessValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
