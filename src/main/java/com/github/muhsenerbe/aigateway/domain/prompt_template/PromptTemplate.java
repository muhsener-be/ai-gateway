package com.github.muhsenerbe.aigateway.domain.prompt_template;

import com.github.muhsenerbe.aigateway.domain.shared.IllegalObjectException;
import com.github.muhsenerbe.aigateway.domain.shared.SoftDeletableEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.SQLDelete;

import java.net.URI;
import java.util.UUID;

@Entity
@Table(name = "prompt_templates")
@SQLDelete(sql = "UPDATE prompt_templates SET deleted_at = CURRENT_TIMESTAMP WHERE id = ?")
@Getter
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PromptTemplate extends SoftDeletableEntity {

    @Column(name = "slug", nullable = false)
    private String slug;


    @Column(name = "goal")
    private String goal;

    @Column(name = "source_reference")
    private URI sourceReference;

    @Column(name = "ethical_considerations")
    private String ethicalConsiderations;


    protected PromptTemplate(UUID id, String slug, String goal, URI sourceReference, String ethicalConsiderations) {
        super(id);
        this.slug = slug;
        this.goal = goal;
        this.sourceReference = sourceReference;
        this.ethicalConsiderations = ethicalConsiderations;
    }

    @Builder(access = AccessLevel.PROTECTED)
    private static PromptTemplate create(String slug, String goal, URI sourceReference, String ethnicalConsiderations) {
        PromptTemplate promptTemplate = new PromptTemplate(null, slug, goal, sourceReference, ethnicalConsiderations);
        promptTemplate.validate();
        return promptTemplate;
    }

    private void validate() {
        if (slug == null || slug.isBlank())
            throw new IllegalObjectException("a non-blank slug must be provided for prompt-template");
    }

}
