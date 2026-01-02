package com.library.library_api.user.dto;

import java.util.UUID;

import com.library.library_api.user.model.User;

import lombok.Data;

@Data
public class UserResponseDto {
    private UUID id;
    private String name;
    private String email;
    
    public UserResponseDto(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.email = user.getEmail();
    }
}