package com.me.management.model;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/23/2024
 * @project users
 * &
 */

@Getter
@Setter
@ToString

public class BaseEntity implements Serializable {

    @NotNull
    private Long Id;
    private LocalDateTime createdAt;

    public BaseEntity(Long id) {
        Id = id;
        this.createdAt = LocalDateTime.now();
    }



}
