package com.library.library_api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.models.User;
import com.library.library_api.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user){
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public Boolean existsByEmail(String email){
        Boolean emailAlreadyInUse = userRepository.existsByEmail(email);
        return emailAlreadyInUse;
    }

    public User getUser(String email){
        User byEmail = userRepository.findByEmail(email);
        return byEmail;
    }
}
