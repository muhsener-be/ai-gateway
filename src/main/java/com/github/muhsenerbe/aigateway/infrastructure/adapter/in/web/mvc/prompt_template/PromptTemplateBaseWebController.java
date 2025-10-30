package com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.mvc.prompt_template;


import com.github.muhsenerbe.aigateway.application.exception.prompt_template.DuplicatePromptTemplateException;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.PromptTemplateApplicationService;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create.CreatePromptTemplateCommand;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.create.PromptTemplateCreationResponse;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list.ListPromptTemplateQuery;
import com.github.muhsenerbe.aigateway.application.ports.in.prompt_template.list.PromptTemplateSummary;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequiredArgsConstructor
public abstract class PromptTemplateBaseWebController {

    private final PromptTemplateWebMapper mapper;
    private final PromptTemplateApplicationService service;

    @GetMapping("/new")
    public String showCreatePromptForm(Model model) {
        // Thymeleaf'e 'th:object' için boş bir çanta veriyoruz.
        // Eğer 'promptForm' adında bir DTO modelde yoksa,
        // Thymeleaf "th:object" bağlamasında hata verir.
        if (!model.containsAttribute("promptForm")) {
            model.addAttribute("promptForm", new CreateTemplateForm());
        }

        // "templates/prompts/create-form.html" dosyasını render et.
        return "prompts/create-form";
    }


    @PostMapping("/create")
    public String handleCreatePromptTemplateForm(
            @Valid @ModelAttribute("promptForm") CreateTemplateForm form,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes
    ) {

        if (bindingResult.hasErrors()) {
            return "prompts/create-form";
        }


        try {
            CreatePromptTemplateCommand command = mapper.toCreateCommand(form);
            PromptTemplateCreationResponse response = service.create(command);
        } catch (DuplicatePromptTemplateException duplicatException) {
            bindingResult.rejectValue("slug", "slug.duplicate", "Bu slug zaten kullanılıyor.");
            return "prompts/create-form";
        } catch (Exception e) {
            bindingResult.reject("global.error", "Beklenmedik bir hata oluştu: " + e.getMessage());
            return "prompts/create-form";
        }


        redirectAttributes.addFlashAttribute("successMessage",
                "Prompt Template '" + form.getSlug() + "' başarıyla oluşturuldu.");

        return "redirect:/prompts/list";

    }

    @GetMapping("/list")
    public String listPromptTemplates(
            // Varsayılan sayfalama: 10'lu, slug'a göre sıralı
            @PageableDefault(size = 10, sort = "slug", direction = Sort.Direction.ASC) Pageable pageable,
            Model model
    ) {


        ListPromptTemplateQuery query = mapper.toListQuery(pageable);
        Page<PromptTemplateSummary> page = service.list(query);

        model.addAttribute("promptPage", page);

        // 3. "templates/prompts/list-page.html" dosyasını render et
        return "prompts/list-page";
    }


}
