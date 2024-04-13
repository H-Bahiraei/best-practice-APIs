package com.me.management.controller;

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
 * @date 2/24/2024
 * @project management
 * &
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler
    public ResponseEntity<String> cacheIsGone(Exception exception) {
        System.out.println("exception = " + exception.getMessage());
        return new ResponseEntity<>("there is a problem in server from Exception", HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseEntity<String> handleNotFound(RuntimeException exception) { //***
        System.out.println("exception = " + exception.getMessage());
        return new ResponseEntity<String>("we dont have this entity from Exception", HttpStatus.NOT_FOUND);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<String>(errors.toString(), HttpStatus.BAD_REQUEST);
    }

}
