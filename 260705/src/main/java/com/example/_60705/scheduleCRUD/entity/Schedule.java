package com.example._60705.scheduleCRUD.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends DateManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 700)
    private String content;

    public Schedule(String t, String c) {
        this.title = t;
        this.content = c;
    }

    public void updateDate() {
        updateUpdatedAt();
    }
}
