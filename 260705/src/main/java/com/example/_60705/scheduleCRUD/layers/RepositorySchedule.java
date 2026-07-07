package com.example._60705.scheduleCRUD.layers;

import com.example._60705.scheduleCRUD.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositorySchedule extends JpaRepository<Schedule, Long> {
}
