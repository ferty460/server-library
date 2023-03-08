package com.example.server.service;

import com.example.server.entity.AuthorEntity;
import com.example.server.entity.PublisherEntity;
import com.example.server.exception.ValidationExceptionPublisher;
import com.example.server.repo.PublisherRepo;
import com.example.server.util.PublisherValidationUtils;
import org.springframework.stereotype.Service;

@Service
public class PublisherService {
    private final PublisherRepo repo;
    public PublisherService(PublisherRepo repo) {
        this.repo = repo;
    }
    public PublisherEntity save(PublisherEntity publisher) throws ValidationExceptionPublisher {
        PublisherValidationUtils.validationPublisher(publisher);
        return repo.save(publisher);
    }
    public Iterable<PublisherEntity> getAll() {
        return repo.findAll();
    }
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
