package com.codewithike.linkedin_clone.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codewithike.linkedin_clone.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {
    boolean existsByEmail(String email);
}
