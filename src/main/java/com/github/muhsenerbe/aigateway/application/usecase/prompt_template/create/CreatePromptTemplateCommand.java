package com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create;

import com.github.muhsenerbe.aigateway.domain.shared.AssertUtils;
import lombok.Builder;

import java.net.URI;

public record CreatePromptTemplateCommand(String slug, String goal, URI sourceReference, String ethicalConsiderations) {

    @Builder(toBuilder = true)
    public CreatePromptTemplateCommand(String slug, String goal, URI sourceReference, String ethicalConsiderations) {
        this.slug = slug;
        this.goal = goal;
        this.sourceReference = sourceReference;
        this.ethicalConsiderations = ethicalConsiderations;

        AssertUtils.notNull(slug, "Slug cannot be null!");
    }
}
