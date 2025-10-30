package com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create;

import com.github.muhsenerbe.aigateway.domain.shared.AssertUtils;

import java.net.URI;

public record CreatePromptTemplateCommand(String slug, String goal, URI sourceReference, String ethicalConsiderations) {

    public CreatePromptTemplateCommand {
        AssertUtils.notNull(slug, "Slug cannot be null!");
    }
}
