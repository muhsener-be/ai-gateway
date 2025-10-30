package com.github.muhsenerbe.aigateway.domain.prompt_template;

import com.github.muhsenerbe.aigateway.domain.shared.DomainException;

public class PromptTemplateDomainException extends DomainException {

    public PromptTemplateDomainException(String message) {
        super(message);
    }

    public PromptTemplateDomainException(String message, Throwable cause) {
        super(message, cause);
    }
}
