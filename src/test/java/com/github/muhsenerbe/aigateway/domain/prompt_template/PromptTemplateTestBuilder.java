package com.github.muhsenerbe.aigateway.domain.prompt_template;

import java.net.URI;
import java.util.UUID;

public class PromptTemplateTestBuilder {

    private UUID id;
    private String slug;
    private String goal;
    private URI sourceReference;
    private String ethnicalConsiderations;

    private PromptTemplateTestBuilder() {
        id = UUID.randomUUID();
        slug = "test-slug-" + UUID.randomUUID();
        goal = "Test goal: " + UUID.randomUUID();
        sourceReference = URI.create("https://example.com/" + UUID.randomUUID());
        ethnicalConsiderations = "Test ethical considerations " + UUID.randomUUID();
    }

    public static PromptTemplateTestBuilder aPromptTemplate() {
        return new PromptTemplateTestBuilder();
    }

    public static PromptTemplateTestBuilder from(PromptTemplate template) {
        return aPromptTemplate()
                .withId(template.getId())
                .withSlug(template.getSlug())
                .withGoal(template.getGoal())
                .withSourceReference(template.getSourceReference())
                .withEthnicalConsiderations(template.getEthicalConsiderations());
    }

    public PromptTemplateTestBuilder withId(UUID id) {
        this.id = id;
        return this;
    }

    public PromptTemplateTestBuilder withSlug(String slug) {
        this.slug = slug;
        return this;
    }

    public PromptTemplateTestBuilder withGoal(String goal) {
        this.goal = goal;
        return this;
    }

    public PromptTemplateTestBuilder withSourceReference(URI sourceReference) {
        this.sourceReference = sourceReference;
        return this;
    }

    public PromptTemplateTestBuilder withEthnicalConsiderations(String ethnicalConsiderations) {
        this.ethnicalConsiderations = ethnicalConsiderations;
        return this;
    }

    public PromptTemplate build() {
        return new PromptTemplate(id, slug, goal, sourceReference, ethnicalConsiderations);
    }
}