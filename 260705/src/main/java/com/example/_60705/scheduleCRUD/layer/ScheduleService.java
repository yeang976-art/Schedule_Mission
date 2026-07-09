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

    @Transactional
    public CreateResponseDTO create(CreateRequestDTO request) {
        Schedule s = new Schedule(request.title(), request.content());

        Schedule saveEntity = repository.save(s);

        return CreateResponseDTO.from(saveEntity);
    }

    @Transactional(readOnly = true)
    public GetResponseDTO readOne(Long id) {
        Schedule s = getEntity(id);

        return GetResponseDTO.from(s);
    }

    @Transactional(readOnly = true)
    public List<GetResponseDTO> readAll() {
        List<Schedule> list = repository.findAll();

        return list.stream().map(GetResponseDTO::from).toList();
    }

    @Transactional
    public UpdateResponseDTO edit(Long id, UpdateRequestDTO request) {
        Schedule s = getEntity(id);

        // 더티채킹 믿고 함수 안쓴다

        s.setTitle(request.title());
        s.setContent(request.content());
        s.updateDate();
        return UpdateResponseDTO.from(s);
    }

    @Transactional
    public void remove(Long id) {
        Schedule s = getEntity(id);

        repository.delete(s);
    }

    private Schedule getEntity(Long id) {
        return repository.findById(id).orElseThrow(() -> new NotFoundException("존재하지 않는 일정"));
    }
}
