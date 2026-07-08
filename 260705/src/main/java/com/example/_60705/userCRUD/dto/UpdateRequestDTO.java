package com.example._60705.userCRUD.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UpdateRequestDTO {

    @NotBlank
    private String name;
}
