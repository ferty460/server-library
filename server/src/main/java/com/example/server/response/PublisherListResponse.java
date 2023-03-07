package com.example.server.response;


import com.example.server.entity.AuthorEntity;
import com.example.server.entity.PublisherEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PublisherListResponse extends BaseResponse{
    private Iterable<PublisherEntity> data;
    public PublisherListResponse(Iterable<PublisherEntity> data) {
        super(true, "Издательства");
        this.data = data;
    }
}
