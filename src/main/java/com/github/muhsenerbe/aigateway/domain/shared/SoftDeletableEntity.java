package com.github.muhsenerbe.aigateway.domain.shared;

import jakarta.persistence.Column;
import lombok.Getter;

import java.time.Instant;

@Getter
public abstract class SoftDeletableEntity extends BaseJpaEntity {

    @Column(name = "deleted_at")
    protected Instant deletedAt;


}
