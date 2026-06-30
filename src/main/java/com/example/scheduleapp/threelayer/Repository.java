package com.example.scheduleapp.threelayer;

import com.example.scheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository<Schedule, Long> {
}
