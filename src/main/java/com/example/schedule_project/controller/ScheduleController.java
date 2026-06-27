package com.example.schedule_project.controller;

import com.example.schedule_project.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService schedule_service;
}
