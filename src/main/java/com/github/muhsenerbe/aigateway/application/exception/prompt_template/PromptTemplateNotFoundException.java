package com.github.muhsenerbe.aigateway.application.exception.prompt_template;

import com.github.muhsenerbe.aigateway.application.exception.shared.ResourceNotFoundException;

import java.util.UUID;

public class PromptTemplateNotFoundException extends ResourceNotFoundException {


    public PromptTemplateNotFoundException(UUID id) {
        super("prompt-template", "ID", id);
    }
}
