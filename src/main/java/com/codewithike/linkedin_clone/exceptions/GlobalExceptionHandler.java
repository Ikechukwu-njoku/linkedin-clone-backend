package com.codewithike.linkedin_clone.exceptions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    private final Environment environment;

    public GlobalExceptionHandler(Environment environment) {
        this.environment = environment;
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, Object>> handleUncaughtExceptions(Exception e) {
       var body = new HashMap<String, Object>();
       body.put("message", "An unexpected error occurred");
       body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.toString());

       boolean includeDetail = Arrays.stream(environment.getActiveProfiles())
                               .noneMatch("prod"::equals);
       
       if(includeDetail){
        body.put("errors", Map.of(
            "detail", e.getMessage() != null ? e.getMessage() : "No details available"
        ));
       }

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationErrors(MethodArgumentNotValidException exception){
        var errors = new HashMap<String, String>();

        //
        exception
        //gives more details about the exception
        .getBindingResult()
        // returns a bunch of error objects
        .getFieldErrors()
        // iterate over these error objects
        .forEach(error -> {
            // add the fieldname and validation message to the map
            errors.put(error.getField(), error.getDefaultMessage());
        });

        var body = new HashMap<String, Object>();
        body.put("message", "Validation failed");
        body.put("status", HttpStatus.BAD_REQUEST.toString());
        body.put("errors", errors);

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String, Object>> handleEmailAlreadyExistsException(EmailAlreadyExistsException exception){
        String message = exception.getMessage() != null ? exception.getMessage() : "Email already registered";
        var body = new HashMap<String, Object>();
        body.put("message", message);
        body.put("status", HttpStatus.CONFLICT.toString());
        
        return ResponseEntity.status(HttpStatus.CONFLICT).body(body);
    }

    @ExceptionHandler(PasswordMismatchException.class)
    public ResponseEntity<Map<String, Object>> handlePasswordMismatchException(PasswordMismatchException exception){
        String message = exception.getMessage() != null ? exception.getMessage() : "Passwords do not match";
        var body = new HashMap<String, Object>();
        body.put("message", message);
        body.put("status", HttpStatus.BAD_REQUEST.toString());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }
}
