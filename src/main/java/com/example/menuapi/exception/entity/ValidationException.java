package com.example.menuapi.exception.entity;

public class ValidationException extends RuntimeException{
    public ValidationException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
}
