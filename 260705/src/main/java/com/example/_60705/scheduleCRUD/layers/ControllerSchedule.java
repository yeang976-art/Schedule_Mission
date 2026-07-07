package com.example._60705.scheduleCRUD.layers;

import com.example._60705.scheduleCRUD.dto.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ControllerSchedule {
    private final ServiceSchedule service;

    @PostMapping("/20020707")
    public ResponseEntity<CreateResponseDTO> post(@RequestBody CreateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/20020707/{id}")
    public ResponseEntity<GetResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("20020707")
    public ResponseEntity<List<GetResponseDTO>> gets() {
        return ResponseEntity.ok(service.getAll());
    }

    @PutMapping("20020707/{id}")
    public ResponseEntity<UpdateResponseDTO> put(@PathVariable Long id) {
        return ResponseEntity.ok(service.update(id));
    }

    @DeleteMapping("20020707/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
