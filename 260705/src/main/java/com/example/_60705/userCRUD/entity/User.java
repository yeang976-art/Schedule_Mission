package com.example._60705.userCRUD.entity;

import com.example._60705.DateManager;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends DateManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    public User(String name, String email, String p) {
        this.name = name;
        this.email = email;
        this.password = p;
    }

    public void updateDate() {
        updateUpdatedAt();
    }
}
