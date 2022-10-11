package com.company.Frontend.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<?> exception(BadRequestException b){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(b.getMessage());
    }
}
