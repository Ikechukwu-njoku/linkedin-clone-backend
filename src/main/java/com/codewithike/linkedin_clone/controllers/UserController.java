package com.codewithike.linkedin_clone.controllers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.codewithike.linkedin_clone.dtos.RegisterUserRequest;
import com.codewithike.linkedin_clone.exceptions.EmailAlreadyExistsException;
import com.codewithike.linkedin_clone.exceptions.PasswordMismatchException;
import com.codewithike.linkedin_clone.services.UserService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(
        @Valid @RequestBody RegisterUserRequest request,
        UriComponentsBuilder uriBuilder
    ){
        var user = userService.registerUser(request);
        var uri = uriBuilder.path("/users/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).body(user);
    }

        
}
