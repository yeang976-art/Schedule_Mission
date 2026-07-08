package com.example._60705.userCRUD.dto;

import jakarta.validation.constraints.*;
import lombok.*;

@Getter
public class LoginRequestDTO {

    @Email
    private String email;
    @Size(min = 8)
    private String password;
}
