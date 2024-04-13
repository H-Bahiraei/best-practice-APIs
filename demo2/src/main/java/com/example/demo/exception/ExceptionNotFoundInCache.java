package com.example.demo.exception;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/19/2024
 * @project demo2
 * &
 */
public class ExceptionNotFoundInCache extends RuntimeException {

    public ExceptionNotFoundInCache(String message) {
        super(message);
    }
}
