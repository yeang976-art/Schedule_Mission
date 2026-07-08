package com.example._60705.scheduleCRUD.layer;

import com.example._60705.scheduleCRUD.dto.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService service;

    @PostMapping("/20020707")
    public ResponseEntity<CreateResponseDTO> post(@RequestBody CreateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/20020707/{id}")
    public ResponseEntity<GetResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOne(id));
    }

    @GetMapping("20020707")
    public ResponseEntity<List<GetResponseDTO>> gets() {
        return ResponseEntity.ok(service.readAll());
    }

    @PutMapping("20020707/{id}")
    public ResponseEntity<UpdateResponseDTO> put(@PathVariable Long id) {
        return ResponseEntity.ok(service.edit(id));
    }

    @DeleteMapping("20020707/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
