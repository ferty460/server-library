package com.example.server.controller;

import com.example.server.entity.BookEntity;
import com.example.server.exception.ValidationException;
import com.example.server.response.BaseResponse;
import com.example.server.response.BookListResponse;
import com.example.server.response.BookResponse;
import com.example.server.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/book")
public class BookController {
    private BookService service;
    private BookController(BookService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<BaseResponse>getAll() {
        return ResponseEntity.ok(new BookListResponse(service.getAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<BaseResponse> registration(@Valid @RequestBody BookEntity data) {
        try {
            BookEntity temp = service.save(data);
            return ResponseEntity.ok(new BookResponse(true, "Книга добавлена",temp));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BookResponse(false, e.getMessage(),null));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody BookEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В книгу внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updata(@RequestBody BookEntity book, @PathVariable long id) {
        try {
            service.save(book);
            return ResponseEntity.ok(new BaseResponse(true, "Поле изменено"));
        } catch (Exception e) {
            return ResponseEntity.ok(new BaseResponse(false, "Невозможно изменить поле"));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse> delete(@RequestParam("id") BookEntity data) {
        try {
            service.delete(data.getId());
            return ResponseEntity.ok(new BaseResponse(true, "Книга удалена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}

