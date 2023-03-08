package com.example.server.service;

import com.example.server.entity.AuthorEntity;
import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationExceptionAuthor;
import com.example.server.repo.AuthorRepo;
import com.example.server.util.AuthorValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepo repo;
    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }
    public AuthorEntity save(AuthorEntity author) throws ValidationExceptionAuthor {
        AuthorValidationUtils.validateAuthor(author);
        return repo.save(author);
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
    public Iterable<AuthorEntity> getAll() {
        return repo.findAll();
    }
}
