package com.example.schedule_project.dto;

import lombok.Getter;
import java.time.LocalDateTime;

@Getter
public class CreateScheduleResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final String password;
    private final LocalDateTime createAt;
    private final LocalDateTime updatedAt;

    public CreateScheduleResponse(Long id, String title, String content, String author, String password, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }
}
