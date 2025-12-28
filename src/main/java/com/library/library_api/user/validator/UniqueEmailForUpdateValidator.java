package com.library.library_api.user.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.library_api.user.annotations.UniqueEmailForUpdate;
import com.library.library_api.user.dto.UpdateUserDto;
import com.library.library_api.user.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailForUpdateValidator implements ConstraintValidator<UniqueEmailForUpdate, UpdateUserDto> {

    @Autowired
    private UserService userService;

    @Override
    public boolean isValid(UpdateUserDto arg0, ConstraintValidatorContext arg1) {
        if (arg0.getEmail() == null || arg0.getEmail().isBlank()) {
            return true;
        }

        return !userService.existsByEmailAndNotUserId(
                arg0.getEmail(),
                arg0.getId());
    }

}
