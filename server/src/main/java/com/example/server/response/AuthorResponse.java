package com.example.server.response;

import com.example.server.entity.AuthorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorResponse extends BaseResponse {
    private AuthorEntity author;
    public AuthorResponse(boolean success, String message, AuthorEntity author) {
        super(success, message);
        this.author = author;
    }
    public AuthorResponse(AuthorEntity author) {
        super(true, "Author data");
    }
}
