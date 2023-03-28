package com.example.server.controller;

import com.example.server.entity.AuthorEntity;
import com.example.server.entity.BookEntity;
import com.example.server.entity.PublisherEntity;
import com.example.server.response.AuthorListResponse;
import com.example.server.response.AuthorResponse;
import com.example.server.response.BaseResponse;
import com.example.server.response.BookResponse;
import com.example.server.service.AuthorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    private AuthorService service;
    private AuthorController(AuthorService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new AuthorListResponse(service.getAll()));
    }
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> registration(@Valid @RequestBody AuthorEntity data) {
        try {
            AuthorEntity temp = service.save(data);
            return ResponseEntity.ok(new AuthorResponse(true, "Автор добавлен", temp));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthorResponse(false, e.getMessage(), null));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse> delete(@RequestParam("id") AuthorEntity data) {
        try {
            service.delete(data.getId());
            return ResponseEntity.ok(new BaseResponse(true, "Автор удален"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody AuthorEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new AuthorResponse(true, "В автора внесены изменения", data));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new AuthorResponse(false, e.getMessage(), null));
        }
    }
}
