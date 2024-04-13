package com.example.demo.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/19/2024
 * @project demo2
 * &
 */
@Getter
@Setter
@EqualsAndHashCode
public class BaseEntity implements Serializable {

    private Long id;
    private LocalDateTime createdAt;

    public BaseEntity() {
//        this.id = new Random().nextLong();
//        this.id= ThreadLocalRandom.current().nextLong(1000L);
        this.createdAt = LocalDateTime.now();
    }

}
