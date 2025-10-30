package com.github.muhsenerbe.aigateway.support.prompt_template;

import com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create.CreatePromptTemplateCommand;
import com.github.muhsenerbe.aigateway.application.usecase.prompt_template.create.PromptTemplateCreationResponse;
import com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.mvc.prompt_template.CreateTemplateForm;
import com.github.muhsenerbe.aigateway.support.shared.TestData;

import java.util.UUID;

public class PromptTemplateTestData {


    public static CreateTemplateForm createForm() {
        return CreateTemplateForm.builder()
                .slug("city-content-generation-" + UUID.randomUUID())
                .ethicalConsiderations("Some ethical considerations for test")
                .goal("Prompt goal is test.")
                .sourceReference(TestData.randomURI())
                .build();

    }


    public static CreatePromptTemplateCommand createCommand() {
        return CreatePromptTemplateCommand.builder()
                .slug("city-content-generation-" + UUID.randomUUID())
                .ethicalConsiderations("Some ethical considerations for test")
                .goal("Prompt goal is test.")
                .sourceReference(TestData.randomURI())
                .build();
    }

    public static PromptTemplateCreationResponse creationResponse() {
        return PromptTemplateCreationResponse.builder().id(UUID.randomUUID()).build();
    }
}
