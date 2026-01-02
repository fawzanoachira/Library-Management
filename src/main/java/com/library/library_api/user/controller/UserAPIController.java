package com.library.library_api.user.controller;

import java.util.HashMap;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.user.dto.CreateUserDto;
import com.library.library_api.user.dto.UpdateUserDto;
import com.library.library_api.user.dto.UserResponseDto;
import com.library.library_api.user.exception.NoUserFoundException;
import com.library.library_api.user.model.User;
import com.library.library_api.user.service.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserAPIController {
    @Autowired
    UserService userService;

    @PostMapping("create")
    public ResponseEntity<HashMap<String, Object>> createUser(@RequestBody @Validated CreateUserDto createUserDto) {
        User user = userService.createUser(createUserDto.toUser());
        UserResponseDto userResponseDto = new UserResponseDto(user);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "User created successfully");
        hashMap.put("data", userResponseDto);
        return new ResponseEntity<>(hashMap, HttpStatus.CREATED);
    }

    @GetMapping("get-user")
    public ResponseEntity<HashMap<String, Object>> getUser(@RequestParam String email) throws NoUserFoundException {
        User user = userService.getUserByEmail(email);
        UserResponseDto userResponseDto = new UserResponseDto(user);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "User fetched successfully");
        hashMap.put("data", userResponseDto);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    @PutMapping("update-user")
    public ResponseEntity<HashMap<String, Object>> updateUser(@RequestBody @Validated UpdateUserDto updateUserDto){
        User updateUser = userService.updateUser(updateUserDto.toUser());
        UserResponseDto userResponseDto = new UserResponseDto(updateUser);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "User updated successfully");
        hashMap.put("data", userResponseDto);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }

    @DeleteMapping("delete-user/{userId}")
    public ResponseEntity<HashMap<String, Object>> deleteUser(@PathVariable UUID userId) throws NoUserFoundException{
        User deleteUser = userService.deleteUser(userId);
        UserResponseDto userResponseDto = new UserResponseDto(deleteUser);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", "User deleted successfully");
        hashMap.put("data", userResponseDto);
        return new ResponseEntity<>(hashMap, HttpStatus.OK);
    }
}