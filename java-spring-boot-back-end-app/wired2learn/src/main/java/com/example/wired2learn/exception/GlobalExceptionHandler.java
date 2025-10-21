package com.example.wired2learn.exception;

// Import HTTP status code
import org.springframework.http.HttpStatus;

// Import Spring object that represents an HTTP response (body + headers + status code)
import org.springframework.http.ResponseEntity;

// Indicates this is a global exception handler
import org.springframework.web.bind.annotation.ControllerAdvice;

// Mark the method to handle specific exceptions
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Object> handleRuntimeException(RuntimeException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", ex.getMessage());
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
}
