package com.example.schedule_project.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class ScheduleRequest {

    private String title;
    private String content;
    private String author;
    private String password;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
}
