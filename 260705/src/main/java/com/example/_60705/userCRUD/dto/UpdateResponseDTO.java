package com.example._60705.userCRUD.dto;

import java.time.LocalDateTime;

public record UpdateResponseDTO(Long id, String name, String email, LocalDateTime updateAt) {

}
