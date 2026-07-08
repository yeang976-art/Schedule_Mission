package com.example._60705.scheduleCRUD.dto;

import com.example._60705.userCRUD.entity.User;

public record CreateRequestDTO(User user, String title, String content) {
}
