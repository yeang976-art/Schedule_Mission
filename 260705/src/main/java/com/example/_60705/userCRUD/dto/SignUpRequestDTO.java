package com.example._60705.userCRUD.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class SignUpRequestDTO {

    @NotBlank
    private String name;
    @Email
    private String email;
    @Size(min = 8)
    private String password;
}
