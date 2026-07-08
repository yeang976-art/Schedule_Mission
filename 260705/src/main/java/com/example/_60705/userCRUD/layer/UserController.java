package com.example._60705.userCRUD.layer;

import com.example._60705.userCRUD.dto.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/c_user")
    public ResponseEntity<CreateResponseDTO> post(@RequestBody CreateRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(request));
    }

    @GetMapping("/c_user/{id}")
    public ResponseEntity<GetResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOne(id));
    }

    @GetMapping("/c_user")
    public ResponseEntity<List<GetResponseDTO>> gets() {
        return ResponseEntity.ok(service.readAll());
    }

    @PutMapping("/c_user/{id}")
    public ResponseEntity<UpdateResponseDTO> put(@PathVariable Long id) {
        return ResponseEntity.ok(service.edit(id));
    }

    @DeleteMapping("/c_user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
