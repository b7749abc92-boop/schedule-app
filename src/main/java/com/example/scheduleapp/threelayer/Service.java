package com.example.scheduleapp.threelayer;

import com.example.scheduleapp.dto.CreateRequest;
import com.example.scheduleapp.dto.CreateResponse;
import com.example.scheduleapp.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class Service {

    private final Repository repository;

    @Transactional
    public CreateResponse save(CreateRequest request) {
        Schedule schedule = new Schedule(
                request.getTitle(),
                request.getContent(),
                request.getAuthor(),
                request.getPassword()
        );
        Schedule saved = repository.save(schedule);
        return new CreateResponse(
                saved.getId(),
                saved.getTitle(),
                saved.getContent(),
                saved.getAuthor(),
                saved.getPassword(),
                saved.getcreatedAt(),
                saved.getmodifiedAt()
        );
    }
}
