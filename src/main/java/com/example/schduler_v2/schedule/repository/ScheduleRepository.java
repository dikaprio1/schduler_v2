package com.example.schduler_v2.schedule.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.schduler_v2.schedule.entity.Schedule;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
