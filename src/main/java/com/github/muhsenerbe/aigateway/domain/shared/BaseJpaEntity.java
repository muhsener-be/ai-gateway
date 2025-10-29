package com.github.muhsenerbe.aigateway.domain.shared;

import jakarta.persistence.*;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
@Getter
public abstract class BaseJpaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    protected UUID id;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    protected Instant createdAt;

    @LastModifiedDate
    @Column(name = "updated_at", nullable = false)
    protected Instant updatedAt;

    @CreatedBy
    @Column(name = "created_by")
    protected UUID createdBy;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected UUID updatedBy;


    @Transient
    private final List<DomainEvent> domainEvents = new ArrayList<>();


    protected BaseJpaEntity() {
    }

    protected BaseJpaEntity(UUID id) {
        this.id = id;
    }

    public List<DomainEvent> releaseEvents() {
        ArrayList<DomainEvent> returnList = new ArrayList<>(this.domainEvents);
        this.domainEvents.clear();
        return returnList;
    }

    protected void registerEvent(@NotNull DomainEvent domainEvent) {
        this.domainEvents.add(domainEvent);
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BaseJpaEntity that = (BaseJpaEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
