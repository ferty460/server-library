package com.example.server.repo;

import com.example.server.entity.BookEntity;
import com.example.server.entity.PublisherEntity;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepo extends CrudRepository<PublisherEntity,Long> {
}
