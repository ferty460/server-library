package com.example.server.repo;

import com.example.server.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {
}
