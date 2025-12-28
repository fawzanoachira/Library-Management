package com.library.library_api.user.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.library_api.user.annotations.UniqueEmail;
import com.library.library_api.user.service.UserService;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {

	@Autowired
	private UserService userService;

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value != null && !userService.existsByEmail(value);
	}

}