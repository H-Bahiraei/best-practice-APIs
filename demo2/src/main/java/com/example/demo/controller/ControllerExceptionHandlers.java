package com.example.demo.controller;

import com.example.demo.exception.ExceptionNotFoundInCache;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mehrad https://github.com/H-Bahiraei
 * @date 3/19/2024
 * @project demo2
 * &
 */

@ControllerAdvice
public class ControllerExceptionHandlers {

    @ExceptionHandler(ExceptionNotFoundInCache.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> exceptionNotFoundInCache(ExceptionNotFoundInCache exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<String> methodArgumentNotValidException (MethodArgumentNotValidException exception ){
        Map<String, String> errors = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);    }
}
