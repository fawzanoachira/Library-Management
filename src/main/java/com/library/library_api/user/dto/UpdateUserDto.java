package com.library.library_api.user.dto;

import java.util.UUID;

import com.library.library_api.user.annotations.UniqueEmailForUpdate;
import com.library.library_api.user.model.User;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@UniqueEmailForUpdate(message = "Email already in use by another user")
public class UpdateUserDto {

    @Valid
    private UUID id;
    private String name;
    private String email;
    @Size(min = 6, message = "password should be atleast 6 characters")
    private String passwordHashed;

    public User toUser() {
        return new User()
                .setId(id)
                .setName(name)
                .setEmail(email != null ? email.toLowerCase() : null)
                .setPasswordHashed(passwordHashed);
    }

}
