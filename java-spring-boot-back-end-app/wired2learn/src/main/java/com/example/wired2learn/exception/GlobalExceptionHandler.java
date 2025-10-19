package com.example.wired2learn.exception;

// Import HTTP status code
import org.springframework.http.HttpStatus;

// Import Spring object that represents an HTTP response (body + headers + status code)
import org.springframework.http.ResponseEntity;

// Indicates this is a global exception handler
import org.springframework.web.bind.annotation.ControllerAdvice;

//
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

}
