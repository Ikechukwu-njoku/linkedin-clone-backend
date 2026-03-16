package com.codewithike.linkedin_clone.services;

import org.springframework.stereotype.Service;

import com.codewithike.linkedin_clone.config.PasswordHasher;
import com.codewithike.linkedin_clone.dtos.RegisterUserRequest;
import com.codewithike.linkedin_clone.dtos.UserDto;
import com.codewithike.linkedin_clone.enums.Role;
import com.codewithike.linkedin_clone.exceptions.EmailAlreadyExistsException;
import com.codewithike.linkedin_clone.exceptions.PasswordMismatchException;
import com.codewithike.linkedin_clone.mappers.Usermapper;
import com.codewithike.linkedin_clone.repositories.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final Usermapper userMapper;

    public UserDto registerUser(RegisterUserRequest request){
        // check if the email is already in use
        if(userRepository.existsByEmail(request.getEmail())){
            throw new EmailAlreadyExistsException("Email already registered");
        }
        
        // check if the password and confirm password are the same
        if(!request.getPassword().equals(request.getConfirmPassword())){
            throw new PasswordMismatchException("Passwords do not match");
        }

        
        // create a new user
        var user = userMapper.toEntity(request);
        user.setRole(Role.MEMBER);
        // hash the password
        user.setPassword(PasswordHasher.hashPassword(request.getPassword()));
        userRepository.save(user);

        var userDto = userMapper.toDto(user);
        return userDto;

    }
   
       
}
    
        
