package com.example.schedule_project.service;

import com.example.schedule_project.dto.*;
import com.example.schedule_project.entity.Schedule;
import com.example.schedule_project.repository.ScheduleRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    // 단 건 조회
    @Transactional(readOnly = true)
    public GetScheduleResponse getOne(Long id) {
        Schedule schedule = schedule_repository.findById(id).orElseThrow(() -> new IllegalStateException("존재하지 않는 일정입니다."));

        return new GetScheduleResponse(schedule.getId(),
                schedule.getTitle(), schedule.getContent(), schedule.getAuthor(),
                schedule.getPassword(), schedule.getCreateAt(), schedule.getUpdatedAt());
    }

    // 전체 조회
    @Transactional(readOnly = true)
    public List<GetScheduleResponse> getAll() {
        List<Schedule> schedules = schedule_repository.findAll();
        List<GetScheduleResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            GetScheduleResponse dto = new GetScheduleResponse(schedule.getId(),
                    schedule.getTitle(), schedule.getContent(), schedule.getAuthor(),
                    schedule.getPassword(), schedule.getCreateAt(), schedule.getUpdatedAt()
            );
            dtos.add(dto);
        }
        return dtos;
    }
}
