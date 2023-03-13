package com.example.server.repo;

import com.example.server.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface BookRepo extends CrudRepository<BookEntity,Long> {
    Iterable<BookEntity> findByTitle(String title);
}
