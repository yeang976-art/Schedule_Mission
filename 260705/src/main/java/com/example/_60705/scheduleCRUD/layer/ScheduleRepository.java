package com.example._60705.scheduleCRUD.layer;

import com.example._60705.scheduleCRUD.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
