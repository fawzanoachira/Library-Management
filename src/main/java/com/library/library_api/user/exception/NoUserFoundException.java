package com.library.library_api.user.exception;

public class NoUserFoundException extends Exception{
    public NoUserFoundException(String email){
        super(email);
    }
}
