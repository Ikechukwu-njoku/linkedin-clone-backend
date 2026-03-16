package com.codewithike.linkedin_clone.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class UserDto {
    private UUID id;
    private String firstname;
    private String lastname;
    private String email;
}
