package com.example._60705.userCRUD.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class LoginRequestDTO {

    @NotBlank
    @Email
    private String email;

    @NotBlank
    @Size(min = 8)
    private String password;
}
