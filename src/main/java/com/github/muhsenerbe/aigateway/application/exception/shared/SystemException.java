package com.github.muhsenerbe.aigateway.application.exception.shared;

public class SystemException extends ApplicationException {


    public SystemException(String message) {
        super(message);
    }

    public SystemException(String message, Throwable cause) {
        super(message, cause);
    }
}
