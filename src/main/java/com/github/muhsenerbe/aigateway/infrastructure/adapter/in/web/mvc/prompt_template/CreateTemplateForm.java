package com.github.muhsenerbe.aigateway.infrastructure.adapter.in.web.mvc.prompt_template;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URI;

@Data
@NoArgsConstructor
@Builder(toBuilder = true)
@AllArgsConstructor
public class CreateTemplateForm {

    @NotBlank(message = "Slug alanı zorunludur.")
    @Size(min = 3, max = 100, message = "Slug 3 ila 100 karakter arasında olmalı.")
    @Pattern(regexp = "^[a-z0-9-]+$", message = "Slug sadece küçük harf, rakam ve '-' içerebilir.")
    private String slug;

    @Size(max = 500, message = "Amaç 500 karakterden fazla olamaz.")
    private String goal;

    private URI sourceReference;

    @Size(max = 1000, message = "Etik hususlar 1000 karakterden fazla olamaz.")
    private String ethicalConsiderations;
}
