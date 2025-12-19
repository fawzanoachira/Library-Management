package com.library.library_api.validators;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.library_api.annotations.UniqueEmail;
import com.library.library_api.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private UserService userService;

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

	// @Override
	// public boolean isValid(String value, ConstraintValidatorContext context) {
	// 	return value != null && !userService.isEmailAlreadyInUse(value);
	// }
	
}