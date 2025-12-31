package com.library.library_api.book.validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.library.library_api.book.annotations.BookFOundOrNot;
import com.library.library_api.book.repository.BookRepository;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BookFoundOrNotValidator implements ConstraintValidator<BookFOundOrNot, Long> {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }
        return bookRepository.existsById(value);
    }
}
