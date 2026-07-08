package com.example._60705.userCRUD.layer;

import com.example._60705.userCRUD.dto.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @PostMapping("/c_userSignUp")
    public ResponseEntity<SignUpResponseDTO> post1(@RequestBody SignUpRequestDTO request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.signUp(request));
    }

    @PostMapping("/c_userLogin")
    public ResponseEntity<Void> post2(@Valid @RequestBody LoginRequestDTO request, HttpSession session) {
        UserSession userSession = service.login(request);
        session.setAttribute("loginUser", userSession);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/c_user/{id}")
    public ResponseEntity<GetResponseDTO> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.readOne(id));
    }

    @GetMapping("/c_user")
    public ResponseEntity<List<GetResponseDTO>> gets() {
        return ResponseEntity.ok(service.readAll());
    }

    @PatchMapping("/c_user")
    public ResponseEntity<UpdateResponseDTO> patch(
            @SessionAttribute(name = "loginUser", required = false) UserSession session,
            @RequestBody UpdateRequestDTO request) {
        return ResponseEntity.ok(service.edit(session.id(), request));
    }

    @DeleteMapping("/c_user/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.remove(id);
        return ResponseEntity.noContent().build();
    }
}
