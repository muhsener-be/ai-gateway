package com.github.muhsenerbe.aigateway.domain.prompt_template;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.net.URI;

@Component
@RequiredArgsConstructor
public class PromptTemplateFactory {


    public PromptTemplate create(String slug, String goal, URI sourceReference, String ethnicalConsiderations) {
        return PromptTemplate.builder()
                .slug(slug)
                .goal(goal)
                .sourceReference(sourceReference)
                .ethnicalConsiderations(ethnicalConsiderations)
                .build();
    }
}
