package com.example.server.util;

import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationException;

public class ValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationException {
        String author = book.getAuthor();
        if (author == null || author.isBlank() || author.length() < 3 || author.length() > 35) {
            throw new ValidationException("Автор должен быть в пределах от 3 до 35 символов");
        }
        String title = book.getTitle();
        if (title == null || title.isBlank() || title.length() < 3 || title.length() > 35) {
            throw new ValidationException("Название должно быть в пределах от 3 до 35 символов");
        }
        String publishing = book.getPublishing();
        if (publishing == null || publishing.isBlank() || publishing.length() < 3 || publishing.length() > 35) {
            throw new ValidationException("Издательство должно быть в пределах от 3 до 35 символов");
        }
        String kind = book.getKind();
        if (kind == null || kind.isBlank() || kind.length() < 3 || kind.length() > 35) {
            throw new ValidationException("Жанр должен быть в пределах от 3 до 35 символов");
        }
        int year = book.getYear();
        if (year > 2023) {
            throw new ValidationException("Год не может быть больше нынешнего");
        }
    }
}
