package com.example.schedule_project.dto;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class ScheduleResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final String author;
    private final LocalDateTime createAt;
    private final LocalDateTime updatedAt;
}
