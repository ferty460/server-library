package com.example.server.util;

import com.example.server.entity.AuthorEntity;
import com.example.server.exception.ValidationExceptionAuthor;

public class AuthorValidationUtils {
    public static void validateAuthor(AuthorEntity data) throws ValidationExceptionAuthor {
        String name = data.getName();
        if (name == null || name.isBlank()) {
            throw new ValidationExceptionAuthor("Поле Имя не может быть пустым");
        }
        String surname = data.getSurname();
        if (surname == null || surname.isBlank()) {
            throw new ValidationExceptionAuthor("Поле Фамилия не может быть пустым");
        }
    }
}
