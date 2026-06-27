package com.example.schedule_project.service;

import com.example.schedule_project.dto.*;
import com.example.schedule_project.entity.Schedule;
import com.example.schedule_project.repository.ScheduleRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final ScheduleRepository schedule_repository;

    // 저장
    @Transactional
    public CreateScheduleResponse save(CreateScheduleRequest request) {
        Schedule schedule = new Schedule(request.getTitle(), request.getContent(), request.getAuthor(),
                request.getPassword(), request.getCreateAt(), request.getUpdatedAt());

        Schedule savedSchedule = schedule_repository.save(schedule);

        return new CreateScheduleResponse(savedSchedule.getId(),
                savedSchedule.getTitle(), savedSchedule.getContent(), savedSchedule.getAuthor(),
                savedSchedule.getPassword(), savedSchedule.getCreateAt(), savedSchedule.getUpdatedAt());
    }
}
