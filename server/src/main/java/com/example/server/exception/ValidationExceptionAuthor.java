package com.example.server.exception;

import javax.validation.ValidationException;

public class ValidationExceptionAuthor extends ValidationException {
    public ValidationExceptionAuthor(String message) {
        super(message);
    }
}
