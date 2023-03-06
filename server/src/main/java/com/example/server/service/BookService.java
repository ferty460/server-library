package com.example.server.service;

import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationException;
import com.example.server.repo.BookRepo;
import com.example.server.util.ValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;
    public BookService(BookRepo repo){
        this.repo = repo;
    }

    public BookEntity save(BookEntity book) throws ValidationException {
        ValidationUtils.validateBook(book);
        return repo.save(book);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Iterable<BookEntity> getAll() {
        return repo.findAll();
    }
}
