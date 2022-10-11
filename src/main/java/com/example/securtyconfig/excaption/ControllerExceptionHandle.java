package com.company.Frontend.exception;

import com.company.Frontend.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandle {
    @ExceptionHandler({BadRequestException.class})
    public ResponseEntity<?> handlerException(BadRequestException e){
        return ResponseEntity.badRequest().body(
                Response.builder()
                        .timeStep(LocalDateTime.now())
                        .status(HttpStatus.BAD_REQUEST)
                        .statusCode(HttpStatus.BAD_REQUEST.value())
                        .data(Map.of("Error", e.getMessage()))
                        .build()
        );
    }
}
