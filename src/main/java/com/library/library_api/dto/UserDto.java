package com.library.library_api.dto;

import org.springframework.stereotype.Component;

import com.library.library_api.models.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Component
public class UserDto {

    @Valid

    @NotBlank(message = "name is required")
    private String name;

    @NotBlank(message = "email is required")
    private String email;

    @NotBlank(message = "password is required")
    @NotNull(message = "password is required")
    @Min(value = 6, message = "password should be atleast 6 characters")
    private String passwordHashed;

    public User toUser() {
        return new User()
                .setName(name)
                .setEmail(email.toLowerCase())
                .setPasswordHashed(passwordHashed);
    }

}
