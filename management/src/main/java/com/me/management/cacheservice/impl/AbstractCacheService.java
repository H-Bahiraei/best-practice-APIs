package com.me.management.cacheservice.impl;

import com.me.management.exception.ExceptionInsertCache;
import com.me.management.exception.NotFoundException;
import com.me.management.model.BaseEntity;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/23/2024
 * @project users
 * &
 */
public abstract class AbstractCacheService<K extends Long, V extends BaseEntity> {

    public static final java.lang.Long DEFAULT_CACHE_TIMEOUT = 30000L; // ***
    private Map<Long, V> cache = new HashMap<>();

    protected V save(V valueObject) {
        if (valueObject != null && valueObject.getId() != null) {
//            V insertedValue = Optional.ofNullable(this.cache.put(valueObject.getId(), valueObject))
//                    .orElseThrow(() -> new CacheIsGoneException("cache is not available"));
            this.cache.put(valueObject.getId(), valueObject);//***
            V fetchedValue = this.get(valueObject.getId());
            if (Objects.equals(valueObject, fetchedValue))
                return valueObject;
            else
                throw new ExceptionInsertCache("It didnt save");
        } else {
            throw new ExceptionInsertCache("obj cannot be nul!!!");
        }

    }


    protected V get(Long key) {
        this.clean();
        if (this.containsKey(key) && !this.isExpired(key)) { // ***
            return Optional.ofNullable(this.cache.get(key)).
                    orElseThrow(() -> new RuntimeException("Value is null")); //TODO specialized Exception Value is null
        } else {
//            return null;
            throw new NotFoundException("there is not in cache"); // ***
        }
    }

    protected Boolean containsKey(Long key) {
        return this.cache.containsKey(key);
    }




    protected void clean() {
        for (Long key : this.getExpiredKeys()) {
            this.cache.remove(key);
        }
    }

    protected Set<Long> getExpiredKeys() { //***
        return this.cache.keySet().stream()
                .filter(this::isExpired)
                .collect(Collectors.toSet()); //***
    }

    protected Boolean isExpired(Long key) {
        LocalDateTime expirationTime = this.cache.get(key).getCreatedAt()
                .plus(DEFAULT_CACHE_TIMEOUT, ChronoUnit.MILLIS); // ***
        return LocalDateTime.now().isAfter(expirationTime);
    }
    protected Map<Long, V> fetchAll() {
        return this.cache;
    }
}
