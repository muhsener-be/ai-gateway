package com.github.muhsenerbe.aigateway.domain.user;

import com.github.muhsenerbe.aigateway.domain.shared.DomainException;

public class UserDomainException extends DomainException {


    public UserDomainException(String message) {
        super(message);
    }

    public UserDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
