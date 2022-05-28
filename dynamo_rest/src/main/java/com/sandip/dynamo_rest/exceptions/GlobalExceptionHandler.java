package com.sandip.dynamo_rest.exceptions;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    String entityNotFoundExceptionHandler(EntityNotFoundException exception){
        return exception.getMessage();
    }
}
