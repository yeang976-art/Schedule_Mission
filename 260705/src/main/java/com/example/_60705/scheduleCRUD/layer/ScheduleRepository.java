package com.example._60705.scheduleCRUD.layer;

import com.example._60705.scheduleCRUD.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    List<Schedule> findAllByOrderByUpdatedAtDesc();

    void deleteByUser_Id(Long userId);
}
