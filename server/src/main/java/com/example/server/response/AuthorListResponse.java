package com.example.server.response;

import com.example.server.entity.AuthorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorListResponse extends BaseResponse {
    private Iterable<AuthorEntity> data;
    public AuthorListResponse(Iterable<AuthorEntity> data) {
        super(true, "Authors");
        this.data = data;
    }
}
