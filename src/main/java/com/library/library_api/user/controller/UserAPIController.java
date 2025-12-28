package com.library.library_api.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.library.library_api.user.dto.UserDto;
import com.library.library_api.user.exception.NoUserFoundException;
import com.library.library_api.user.model.User;
import com.library.library_api.user.service.UserService;

@RestController
@RequestMapping("/api/users/")
public class UserAPIController {
    @Autowired
    UserService userService;

    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody @Validated UserDto userDto) {
        User user = userService.createUser(userDto.toUser());
        return ResponseEntity.ok(user);
    }

    @GetMapping("get-user")
    public User getUser(@RequestParam String email) throws NoUserFoundException {
        User user = userService.getUser(email);
        return user;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }

    // @ResponseStatus(HttpStatus.BAD_REQUEST)
    // @ExceptionHandler(NoUserFoundException.class)
    // public Map<String, String> handleNoUserFoundExceptions(NoUserFoundException ex) {
    //     Map<String, String> errors = new HashMap<>();
    //     errors.put("msg", ex.getMessage());
    //     return errors;
    // }
}