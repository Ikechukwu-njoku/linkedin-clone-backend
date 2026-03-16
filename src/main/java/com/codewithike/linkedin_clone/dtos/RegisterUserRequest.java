package com.codewithike.linkedin_clone.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class RegisterUserRequest {
    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "First Name must not exceed 255 characters")
    private String firstname;

    @NotBlank(message = "Name is required")
    @Size(max = 255, message = "First Name must not exceed 255 characters")
    private String lastname;

    @NotBlank(message = "Email is required")
    @Email(message = "Must be a valid email")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 25, message = "Password must not be less than 6 characters")
    private String password;

    @NotBlank(message = "Password is required")
    @Size(min = 6, max = 25, message = "Password must not be less than 6 characters")
    private String confirmPassword;
}
