package com.example.catonsenh2.service;

import com.example.catonsenh2.models.UserModel;
import com.example.catonsenh2.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> 
}
