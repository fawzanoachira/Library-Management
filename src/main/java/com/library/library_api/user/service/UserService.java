package com.library.library_api.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_api.user.exception.NoUserFoundException;
import com.library.library_api.user.model.User;
import com.library.library_api.user.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        User savedUser = userRepository.save(user);
        return savedUser;
    }

    public Boolean existsByEmail(String email) {
        Boolean emailAlreadyInUse = userRepository.existsByEmail(email);
        return emailAlreadyInUse;
    }

    public User getUser(String email) throws NoUserFoundException {
        User byEmail = userRepository.findByEmail(email).orElseThrow(() -> new NoUserFoundException("No user found for this email: "+ email));
        return byEmail;
    }
}
