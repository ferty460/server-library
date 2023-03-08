package com.example.server.service;

import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationExceptionBook;
import com.example.server.repo.BookRepo;
import com.example.server.util.BookValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;
    public BookService(BookRepo repo){
        this.repo = repo;
    }

    public BookEntity save(BookEntity book) throws ValidationExceptionBook {
        BookValidationUtils.validateBook(book);
        return repo.save(book);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Iterable<BookEntity> getAll() {
        return repo.findAll();
    }
    public Iterable<BookEntity> getPublisher(String title, String city) {
        return repo.findDistinctByPublisher_PublisherOrPublisher_City(title, city);
    }
}
