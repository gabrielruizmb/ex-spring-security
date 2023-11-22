package com.example.ex001springsecurity.user;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.ex001springsecurity.configs.SecurityConfig;

@Service
public class UserService {
    
    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void post(UserModel userModel) {
        userModel.setPassword(
            SecurityConfig.passwordEncoder().encode(userModel.getPassword())
        );

        userRepository.save(userModel);
    }

    public List<UserModel> getAll() {
        return userRepository.findAll();
    }
}
