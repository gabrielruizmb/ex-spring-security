package com.example.ex001springsecurity.user;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
    UserDetails findByUsername(String username);
}
