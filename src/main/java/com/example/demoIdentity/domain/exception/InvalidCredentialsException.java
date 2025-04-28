package com.example.demoIdentity.domain.exception;

public class InvalidCredentialsException extends CustomException{
    public InvalidCredentialsException(String message) {
        super(message, "INVALID_CREDENTIALS", 401);
    }
}
