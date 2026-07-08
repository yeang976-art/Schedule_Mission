package com.example._60705.userCRUD.layer;

import com.example._60705.exceptions.*;
import com.example._60705.userCRUD.dto.*;
import com.example._60705.userCRUD.entity.User;
import jakarta.validation.Valid;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private User entity;

    // 회원가입
    @Transactional
    public SignUpResponseDTO signUp(SignUpRequestDTO request) {
        entity = new User(request.getName(), request.getEmail(), request.getPassword());
        User saveUser = repository.save(entity);

        return new SignUpResponseDTO(saveUser.getId(), saveUser.getName(), saveUser.getEmail(), saveUser.getCreateAt());
    }

    // 로그인
    @Transactional(readOnly = true)
    public UserSession login(@Valid LoginRequestDTO request) {
        entity = repository.findUserName(request.getEmail()).orElseThrow(() -> new NotFoundException("존재하지 않는 사용자"));

        return new UserSession(entity.getId(), entity.getName(), entity.getEmail());
    }

    @Transactional(readOnly = true)
    public GetResponseDTO readOne(Long id) {
        entity = checkData(id);

        return new GetResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getCreateAt(), entity.getUpdatedAt());
    }

    @Transactional
    public List<GetResponseDTO> readAll() {
        List<User> list = repository.findAll();

        return list.stream()
                .map(a -> new GetResponseDTO(a.getId(), a.getName(), a.getEmail(), a.getCreateAt(), a.getUpdatedAt()))
                .toList();
    }

    // 이름 변경
    @Transactional
    public UpdateResponseDTO edit(Long id, UpdateRequestDTO request) {
        entity = checkData(id);
        entity.setName(request.getName());
        entity.updateDate();

        return new UpdateResponseDTO(entity.getId(), entity.getName(), entity.getEmail(), entity.getUpdatedAt());
    }

    @Transactional
    public void remove(Long id) {
        entity = checkData(id);

        repository.delete(entity);
    }

    private User checkData(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("존재하지 않는 사용자"));
    }
}
