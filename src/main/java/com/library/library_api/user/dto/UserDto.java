package com.library.library_api.user.dto;

import com.library.library_api.user.annotations.UniqueEmail;
import com.library.library_api.user.model.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserDto {

    @Valid

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    @UniqueEmail(message = "A user already registered with this email")
    private String email;

    @NotBlank(message = "password is required")
    @NotNull(message = "password is required")
    @Size(min = 6, message = "password should be atleast 6 characters")
    private String passwordHashed;

    public User toUser() {
        return new User()
                .setName(name)
                .setEmail(email.toLowerCase())
                .setPasswordHashed(passwordHashed);
    }

}
