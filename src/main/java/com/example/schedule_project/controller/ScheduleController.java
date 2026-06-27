package com.example.schedule_project.controller;

import com.example.schedule_project.dto.*;
import com.example.schedule_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService schedule_service;

    @PostMapping("/schedule")
    public CreateScheduleResponse createSchedule(@RequestBody CreateScheduleRequest request) {
        return schedule_service.save(request);
    }

    @GetMapping("/schedule/{id}")
    public GetScheduleResponse getSchedule(@PathVariable Long id) {
        return schedule_service.getOne(id);
    }

    @GetMapping("/schedule")
    public List<GetScheduleResponse> getSchedules() {
        return schedule_service.getAll();
    }
}
