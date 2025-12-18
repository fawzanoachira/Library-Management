package com.library.library_api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.dto.UserDto;
import com.library.library_api.models.User;
import com.library.library_api.service.UserService;

@RestController
@RequestMapping("/users/")
public class UserAPIController {
    @Autowired
    UserService userService;
    
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody @Validated UserDto userDto){
        User user = userService.createUser(userDto.toUser());
        return ResponseEntity.ok(user);
    }
}