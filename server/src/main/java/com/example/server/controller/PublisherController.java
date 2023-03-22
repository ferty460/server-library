package com.example.server.controller;

import com.example.server.entity.BookEntity;
import com.example.server.entity.PublisherEntity;
import com.example.server.response.BaseResponse;
import com.example.server.response.PublisherListResponse;
import com.example.server.response.PublisherResponse;
import com.example.server.service.PublisherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/publisher")
public class PublisherController {
    private PublisherService service;
    private PublisherController(PublisherService service) {
        this.service = service;
    }
    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new PublisherListResponse(service.getAll()));
    }
    @PostMapping("/add")
    public ResponseEntity<BaseResponse> registration (@Valid @RequestBody PublisherEntity data) {
        try {
            PublisherEntity temp = service.save(data);
            return ResponseEntity.ok(new PublisherResponse(true, "Издательство добавлено", temp));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new PublisherResponse(false, e.getMessage(), null));
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<BaseResponse> delete(@RequestParam("id") PublisherEntity data) {
        try {
            service.delete(data.getId());
            return ResponseEntity.ok(new BaseResponse(true, "Издательство удалено"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody PublisherEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "В издательство внесены изменения"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}
