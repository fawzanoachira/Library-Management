package com.library.library_api.user.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.library.library_api.user.validator.UniqueEmailForUpdateValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = UniqueEmailForUpdateValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE })
public @interface UniqueEmailForUpdate {
    public String message() default "Email already in use by another user";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}