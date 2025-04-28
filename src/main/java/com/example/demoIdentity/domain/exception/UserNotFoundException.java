package com.example.demoIdentity.domain.exception;

public class UserNotFoundException extends CustomException {

    public UserNotFoundException(String message) {
        super(message, "USER_NOT_FOUND", 404);
    }
}
