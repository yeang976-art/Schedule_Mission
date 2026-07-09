package com.example._60705.scheduleCRUD.layer;

import com.example._60705.scheduleCRUD.dto.*;
import com.example._60705.userCRUD.dto.UserSession;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService service;

    @PostMapping("/20020707")
    public ResponseEntity<CreateResponseDTO> post(
            @Valid @RequestBody CreateRequestDTO request,
            @SessionAttribute(name = "loginUser", required = false) UserSession loginUser
    ) {
        Long loginUserId = loginUser == null ? null : loginUser.id();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.create(request, loginUserId));
    }

    @GetMapping("/20020707/{id}")
    public ResponseEntity<GetResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOne(id));
    }

    @GetMapping("/20020707")
    public ResponseEntity<List<GetResponseDTO>> gets() {
        return ResponseEntity.ok(service.readAll());
    }

    @PutMapping("/20020707/{id}")
    public ResponseEntity<UpdateResponseDTO> put(
            @PathVariable Long id,
            @Valid @RequestBody UpdateRequestDTO request,
            @SessionAttribute(name = "loginUser", required = false) UserSession loginUser
    ) {
        Long loginUserId = loginUser == null ? null : loginUser.id();
        return ResponseEntity.ok(service.edit(id, request, loginUserId));
    }

    @DeleteMapping("/20020707/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable Long id,
            @SessionAttribute(name = "loginUser", required = false) UserSession loginUser
    ) {
        Long loginUserId = loginUser == null ? null : loginUser.id();
        service.remove(id, loginUserId);
        return ResponseEntity.noContent().build();
    }
}
