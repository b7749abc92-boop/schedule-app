package com.example.scheduleapp.threelayer;

import com.example.scheduleapp.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Repository extends JpaRepository<Schedule, Long> {

    List<Schedule> findByAuthorOrderByModifiedAtDesc(String author);

}
