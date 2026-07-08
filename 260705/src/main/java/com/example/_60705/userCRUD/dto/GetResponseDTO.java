package com.example._60705.userCRUD.dto;

import java.time.LocalDateTime;

public record GetResponseDTO(Long id, String name, String email, LocalDateTime createAt, LocalDateTime updateAt) {

}
