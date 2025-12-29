package com.library.library_api.common.exception.user;

import java.util.Collections;
import java.util.HashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.library.library_api.user.exception.NoUserFoundException;

@ControllerAdvice
public class UserCustomExceptionHandler{
    
    @ExceptionHandler(NoUserFoundException.class)
    public ResponseEntity<HashMap<String, Object>> handleNoUserFoundExceptions(NoUserFoundException ex) {
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("msg", ex.getMessage());
        hashMap.put("data", Collections.emptyMap());
        return new ResponseEntity<>(hashMap, HttpStatus.BAD_REQUEST);
    }
}