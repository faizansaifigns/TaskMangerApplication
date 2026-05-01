package com.faizan.taskmanager.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 🔥 Validation Errors
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidation(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Validation Failed");
        response.put("errors", errors);

        return ResponseEntity.badRequest().body(response);
    }

    // 🔥 Runtime Errors
    @ExceptionHandler(jakarta.validation.ConstraintViolationException.class)
    public ResponseEntity<?> handleConstraintViolation(jakarta.validation.ConstraintViolationException ex) {

        Map<String, String> errors = new HashMap<>();

        ex.getConstraintViolations().forEach(error -> {
            String field = error.getPropertyPath().toString();
            errors.put(field, error.getMessage());
        });

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Validation Failed");
        response.put("errors", errors);

        return ResponseEntity.badRequest().body(response);
    }
}