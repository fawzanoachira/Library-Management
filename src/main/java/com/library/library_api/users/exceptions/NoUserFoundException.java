package com.library.library_api.users.exceptions;

public class NoUserFoundException extends Exception{
    public NoUserFoundException(String email){
        super(email);
    }
}
