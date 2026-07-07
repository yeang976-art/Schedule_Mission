package com.example._60705.scheduleCRUD.dto;

import java.time.LocalDateTime;

public record GetResponseDTO(Long id, String title, String content, LocalDateTime createAt, LocalDateTime updateAt) {

}
