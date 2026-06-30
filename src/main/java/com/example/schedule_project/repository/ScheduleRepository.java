package com.example.schedule_project.repository;

import com.example.schedule_project.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByAuthor(String author);
}
