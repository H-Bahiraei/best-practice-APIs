package com.me.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 2/25/2024
 * @project users2
 * &
 */
@ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
public class CacheIsGoneException extends RuntimeException {
    public CacheIsGoneException(String message) {
        super(message);
    }
}
