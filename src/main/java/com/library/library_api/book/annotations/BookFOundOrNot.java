package com.library.library_api.book.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.library.library_api.book.validator.BookFoundOrNotValidator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Constraint(validatedBy = BookFoundOrNotValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface BookFOundOrNot {
    public String message() default "There is no book available for this id";

    public Class<?>[] groups() default {};

    public Class<? extends Payload>[] payload() default {};
}
