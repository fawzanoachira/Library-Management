package com.library.library_api.common.exception.book;

import java.util.Collections;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.library_api.book.exception.NoBookFoundException;

@ControllerAdvice
public class BookCustomExceptionHandler{
    
    @ExceptionHandler(NoBookFoundException.class)
    public ResponseEntity<HashMap<String, Object>> handleNoUserFoundExceptions(NoBookFoundException ex) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", ex.getMessage());
        hashMap.put("data", Collections.emptyMap());
        return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
    }
}