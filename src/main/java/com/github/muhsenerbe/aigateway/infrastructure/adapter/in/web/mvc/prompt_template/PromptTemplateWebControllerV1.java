package com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.mvc.prompt_template;

import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.PromptTemplateApplicationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/prompts")
public class PromptTemplateWebControllerV1 extends PromptTemplateBaseWebController {


    public PromptTemplateWebControllerV1(PromptTemplateWebMapper mapper, PromptTemplateApplicationService service) {
        super(mapper, service);
    }
}
