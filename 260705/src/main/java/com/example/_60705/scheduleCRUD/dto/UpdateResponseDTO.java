package com.example._60705.scheduleCRUD.dto;

import com.example._60705.scheduleCRUD.entity.Schedule;

import java.time.LocalDateTime;

public record UpdateResponseDTO
        (Long id, Long userId, String userName, String title,
         String content, LocalDateTime updateAt) {
    public static UpdateResponseDTO from(Schedule s) {
        return new UpdateResponseDTO(
                s.getId(),
                s.getUser().getId(),
                s.getUser().getName(),
                s.getTitle(),
                s.getContent(),
                s.getUpdatedAt()
        );
    }
}
