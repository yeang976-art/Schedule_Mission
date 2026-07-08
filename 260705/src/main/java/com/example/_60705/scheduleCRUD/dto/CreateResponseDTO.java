package com.example._60705.scheduleCRUD.dto;

import com.example._60705.userCRUD.entity.User;

import java.time.LocalDateTime;

public record CreateResponseDTO(Long id, User user, String title, String content, LocalDateTime createAt) {

}
