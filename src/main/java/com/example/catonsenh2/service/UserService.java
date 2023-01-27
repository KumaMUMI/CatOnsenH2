package com.example.catonsenh2.service;

import com.example.catonsenh2.models.UserModel;
import com.example.catonsenh2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAllUser(){
        return this.userRepository.findAll();
    }

    public Optional<UserModel> findUserByID(Long id){
        return this.userRepository.findById(id);
    }

    public UserModel saveUser(UserModel user){
        return this.userRepository.save(user);
    }

    public Optional<UserModel> updateUser(Long id,UserModel newUser){
        return userRepository.findById(id).map(user -> {
            user.setEmail(newUser.getEmail());
            user.setTel(newUser.getTel());
           user.setAppointment(newUser.getAppointment());
            return userRepository.save(user);
        });
    }

    public void deleteByID(Long id){
        this.userRepository.deleteById(id);
    }
}
