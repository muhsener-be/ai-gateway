package com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.mvc.prompt_template;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

public abstract class PromptTemplateBaseWebController {


    @GetMapping("/new")
    public String showCreatePromptForm(Model model) {

//        // 2. ADIM: "Model" (çanta) hazırlanır.
//        // Niye boş bir obje yolluyoruz?
//        // Çünkü Thymeleaf'teki 'th:object' buna bağlanacak.
//        // Bu, formun hangi alanlara sahip olduğunu bilmesini sağlar.
//        model.addAttribute("promptForm", new PromptTemplateForm());
//
//        // 3. ADIM: Spring'e cevap verilir.
//        // Bu, "templates/prompts/create-form.html" dosyasını
//        // render et (HTML'e çevir) demektir.
        return "prompts/create-form";
    }

}
