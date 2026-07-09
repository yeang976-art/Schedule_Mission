package com.example._60705.scheduleCRUD.entity;

import com.example._60705.DateManager;
import com.example._60705.userCRUD.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Schedule extends DateManager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false) // JPA 차원
    @JoinColumn(nullable = false) // DB 차원
    private User user;

    @Column(nullable = false, length = 200)
    private String title;

    @Column(nullable = false, length = 700)
    private String content;

    public Schedule(User u, String t, String c) {
        this.user = u;
        this.title = t;
        this.content = c;
    }

    public void updateDate() {
        updateUpdatedAt();
    }
}
