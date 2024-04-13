package com.example.demo.service;

import com.example.demo.exception.ExceptionNotFoundInCache;
import com.example.demo.exception.ExceptionSaveInvalidValue;
import com.example.demo.exception.ExceptionUnSuccessSaveInCache;
import com.example.demo.model.BaseEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/19/2024
 * @project demo2
 * &
 */
public abstract class CacheService<Key extends Long, Value extends BaseEntity> {

    private Map<Long, Value> cache = new HashMap<>();

    protected Value save(Value value) {
        if (value != null && value.getId() != null) {
            cache.put(value.getId(), value);
            Value value1 = this.get(value.getId());
            if (value1.equals(value))
                return value1;
            else
                throw new ExceptionUnSuccessSaveInCache("save nashoooood!!!");

        } else {
            throw new ExceptionSaveInvalidValue("not IDDDDDDDDDD");
        }
    }


    protected Value get(Long key) {
        return Optional.ofNullable(cache.get(key))
                .orElseThrow(() -> new ExceptionNotFoundInCache("nadariiiiiim inooooo"));
    }


    protected Long getNextId() {
        try {
            return Collections.max(cache.keySet()) + 1;
        } catch (Exception exception) {
            return 1L;
        }
    }


    private void clean() {
        for (Long key : this.getExpiredKeys()) {
            this.cache.remove(key);
        }
    }

    private Set<Long> getExpiredKeys() {
        return this.cache.keySet().stream().filter(this::isExpired).collect(Collectors.toSet());
    }

    private boolean isExpired(Long key) {
        return LocalDateTime.now().isAfter(
                this.cache.get(key).getCreatedAt()
                        .plus(5000L, ChronoUnit.MILLIS)
        );
    }

}
