package com.example._60705.scheduleCRUD.layer;

import com.example._60705.scheduleCRUD.dto.*;
import com.example._60705.scheduleCRUD.entity.Schedule;
import com.example._60705.exceptions.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository repository;
    private Schedule entity;

    @Transactional
    public CreateResponseDTO create(CreateRequestDTO request) {
        entity = new Schedule(request.user(), request.title(), request.content());

        Schedule saveEntity = repository.save(entity);

        return new CreateResponseDTO(saveEntity.getId(), saveEntity.getUser(), saveEntity.getTitle(),
                saveEntity.getContent(), saveEntity.getCreateAt());
    }

    @Transactional(readOnly = true)
    public GetResponseDTO readOne(Long id) {
        entity = getEntity(id);

        return new GetResponseDTO(entity.getId(), entity.getUser(), entity.getTitle(), entity.getContent(),
                entity.getCreateAt(), entity.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<GetResponseDTO> readAll() {
        List<Schedule> list = repository.findAll();

        return list.stream()
                .map(elements
                        -> new GetResponseDTO(elements.getId(), elements.getUser(), elements.getTitle(),
                        elements.getContent(), elements.getCreateAt(), elements.getUpdatedAt()))
                .toList();
    }

    @Transactional
    public UpdateResponseDTO edit(Long id, UpdateRequestDTO request) {
        entity = getEntity(id);

        // 더티채킹 믿고 함수 안쓴다

        entity.setTitle(request.title());
        entity.setContent(request.content());
        entity.updateDate();
        return new UpdateResponseDTO(entity.getId(), entity.getUser(), entity.getTitle(),
                entity.getContent(), entity.getUpdatedAt());
    }

    @Transactional
    public void remove(Long id) {
        entity = getEntity(id);

        repository.delete(entity);
    }

    private Schedule getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("존재하지 않는 일정"));
    }
}
