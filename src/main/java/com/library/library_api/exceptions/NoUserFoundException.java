package com.library.library_api.exceptions;

public class NoUserFoundException extends Exception{
    public NoUserFoundException(String email){
        super(email);
    }
}
