package com.example.schedule_project.controller;

import com.example.schedule_project.dto.*;
import com.example.schedule_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService schedule_service;

    @PostMapping("/schedule")
    public ScheduleResponse createSchedule(@RequestBody ScheduleRequest request) {
        return schedule_service.save(request);
    }

    @GetMapping("/schedule/{id}")
    public ScheduleResponse getSchedule(@PathVariable Long id) {
        return schedule_service.getOne(id);
    }

    @GetMapping("/schedule")
    public List<ScheduleResponse> getSchedules() {
        return schedule_service.getAll();
    }

    @PutMapping("/schedule/{id}")
    public ScheduleResponse updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequest request) {
        return schedule_service.update(id, request);
    }

    @DeleteMapping("/schedule/{id}")
    public void deleteSchedule(@PathVariable Long id) {
        schedule_service.delete(id);
    }
}
