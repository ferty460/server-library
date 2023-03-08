package com.example.server.util;

import com.example.server.entity.AuthorEntity;
import com.example.server.entity.BookEntity;
import com.example.server.entity.PublisherEntity;
import com.example.server.exception.ValidationExceptionBook;

public class BookValidationUtils {
    public static void validateBook(BookEntity book) throws ValidationExceptionBook {
        String title = book.getTitle();
        if (title == null || title.isBlank()) {
            throw new ValidationExceptionBook("Поле названия не могут быть пустым");
        }
        PublisherEntity publishing = book.getPublisher();
        if (publishing == null) {
            throw new ValidationExceptionBook("Нужно выбрать издательство");
        }
        if (book.getAuthor() == null){
            throw new ValidationExceptionBook("Нужно выбрать автора");
        }
    }
}
