package com.example._60705.scheduleCRUD.dto;

import com.example._60705.scheduleCRUD.entity.Schedule;

import java.time.LocalDateTime;

public record CreateResponseDTO
        (Long id, Long userId, String userName, String title,
        String content, LocalDateTime createAt) {
    public static CreateResponseDTO from(Schedule s) {
        return new CreateResponseDTO(
                s.getId(),
                s.getUser().getId(),
                s.getUser().getName(),
                s.getTitle(),
                s.getContent(),
                s.getCreateAt()
        );
    }
}
