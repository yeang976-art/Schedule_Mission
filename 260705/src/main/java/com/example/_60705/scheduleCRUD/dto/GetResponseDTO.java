package com.example._60705.scheduleCRUD.dto;

import com.example._60705.scheduleCRUD.entity.Schedule;

import java.time.LocalDateTime;

public record GetResponseDTO
        (Long id, Long userId, String userName, String title,
         String content, LocalDateTime createAt, LocalDateTime updateAt) {
    public static GetResponseDTO from(Schedule schedule) {
        return new GetResponseDTO(
                schedule.getId(),
                schedule.getUser().getId(),
                schedule.getUser().getName(),
                schedule.getTitle(),
                schedule.getContent(),
                schedule.getCreateAt(),
                schedule.getUpdatedAt()
        );
    }
}
