package com.example.schedule_project.controller;

import com.example.schedule_project.dto.*;
import com.example.schedule_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService schedule_service;

    @PostMapping("/schedule")
    public ResponseEntity<ScheduleResponse> createSchedule(@RequestBody ScheduleRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(schedule_service.save(request));
    }

    @GetMapping("/schedule/{id}")
    public ResponseEntity<ScheduleResponse> getSchedule(@PathVariable Long id) {
        return ResponseEntity.ok(schedule_service.getOne(id));
    }

    @GetMapping("/schedule")
    public ResponseEntity<List<ScheduleResponse>> getSchedules(@RequestParam(required = false) String author) {
        return ResponseEntity.ok(schedule_service.getAll(author));
    }

    @PutMapping("/schedule/{id}")
    public ResponseEntity<ScheduleResponse> updateSchedule(@PathVariable Long id, @RequestBody ScheduleRequest request) {
        return ResponseEntity.ok(schedule_service.update(id, request));
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id, @RequestBody ScheduleRequest request) {
        schedule_service.delete(id, request);
        return ResponseEntity.noContent().build();
    }
}
