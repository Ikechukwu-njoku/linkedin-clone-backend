package com.codewithike.linkedin_clone.mappers;

import org.mapstruct.Mapper;

import com.codewithike.linkedin_clone.dtos.RegisterUserRequest;
import com.codewithike.linkedin_clone.dtos.UserDto;
import com.codewithike.linkedin_clone.entities.User;

@Mapper(componentModel = "spring")
public interface Usermapper {
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
}
