package com.example._60705.userCRUD.layer;

import com.example._60705.exceptions.*;
import com.example._60705.userCRUD.dto.*;
import com.example._60705.userCRUD.entity.User;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository repository;
    private User entity;

    @Transactional
    public CreateResponseDTO create(CreateRequestDTO request) {
        entity = new User(request.name(), request.email());
        User saveUser = repository.save(entity);

        return new CreateResponseDTO(saveUser.getId(), saveUser.getName(), saveUser.getEmail(), saveUser.getCreateAt());
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

    @Transactional
    public UpdateResponseDTO edit(Long id) {
        entity = checkData(id);
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
