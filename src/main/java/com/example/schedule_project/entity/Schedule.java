package com.example.schedule_project.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Getter
@Entity
@Table
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(length = 1000, nullable = false)
    private String content;

    @Column(length = 50, nullable = false)
    private String author;

    @Column(length = 800, nullable = false)
    private String password;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createAt;

    @LastModifiedDate
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public Schedule(String title, String content, String author, String password, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }

    public void update(String title, String content, String author, String password, LocalDateTime createAt, LocalDateTime updatedAt) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.password = password;
        this.createAt = createAt;
        this.updatedAt = updatedAt;
    }
}
