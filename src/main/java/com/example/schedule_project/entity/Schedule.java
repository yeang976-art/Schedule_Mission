package com.example.schedule_project.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends DateManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title; // 일정 제목

    @Column(length = 1000, nullable = false)
    private String content; // 일정 내용

    @Column(length = 50, nullable = false)
    private String author; // 작성자명

    @Column(length = 800, nullable = false)
    private String password; // 비밀번호

    public Schedule(String title, String content, String author, String password) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
    }

    public void update(String title, String author) {
        this.title = title;
        this.author = author;
        updateUpdatedAt();
    }
}
