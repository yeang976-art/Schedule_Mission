package com.example._60705.scheduleCRUD.layers;

import com.example._60705.scheduleCRUD.dto.*;
import com.example._60705.scheduleCRUD.entity.Schedule;
import com.example._60705.exceptions.*;
import lombok.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.*;

import java.util.*;

@Service
@Getter
@RequiredArgsConstructor
public class ServiceSchedule {
    private final RepositorySchedule repository;
    private Schedule entity;

    @Transactional
    public CreateResponseDTO create(CreateRequestDTO request) {
        entity = new Schedule(request.getTitle(), request.getContent());

        Schedule saveEntity = repository.save(entity);

        return new CreateResponseDTO(saveEntity.getId(), saveEntity.getTitle(), saveEntity.getContent(),
                saveEntity.getCreateAt());
    }

    @Transactional(readOnly = true)
    public GetResponseDTO getOne(Long id) {
        entity = getEntity(id);

        return new GetResponseDTO(entity.getId(), entity.getTitle(), entity.getContent(),
                entity.getCreateAt(), entity.getUpdatedAt());
    }

    @Transactional(readOnly = true)
    public List<GetResponseDTO> getAll() {
        List<Schedule> list = repository.findAll();

        return list.stream()
                .map(elements -> new GetResponseDTO(elements.getId(), elements.getTitle(),
                        elements.getContent(), elements.getCreateAt(), elements.getUpdatedAt()))
                .toList();
    }

    @Transactional
    public UpdateResponseDTO update(Long id) {
        entity = getEntity(id);

        // 더티채킹 믿고 함수 안쓴다

        entity.updateDate();
        return new UpdateResponseDTO(entity.getId(), entity.getTitle(), entity.getContent()
                ,entity.getUpdatedAt());
    }

    @Transactional
    public void delete(Long id) {
        entity = getEntity(id);

        repository.delete(entity);
    }

    private Schedule getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new ScheduleNotFoundException("존재하지 않는 일정입니다."));
    }
}
