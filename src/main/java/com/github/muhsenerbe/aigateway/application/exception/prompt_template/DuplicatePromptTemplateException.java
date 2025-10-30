package com.github.muhsenerbe.aigateway.application.exception.prompt_template;

import com.github.muhsenerbe.aigateway.application.exception.shared.DuplicateException;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class DuplicatePromptTemplateException extends DuplicateException {


    public DuplicatePromptTemplateException(@NotNull String slug) {
        super("prompt-template", Map.of("slug", slug));
    }
}
