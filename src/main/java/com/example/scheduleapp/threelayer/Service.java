package com.example.scheduleapp.threelayer;

import com.example.scheduleapp.dto.CreateRequest;
import com.example.scheduleapp.dto.CreateResponse;
import com.example.scheduleapp.dto.GetResponse;
import com.example.scheduleapp.dto.UpdateResponse;
import com.example.scheduleapp.entity.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

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
                saved.getCreatedAt(),
                saved.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public GetResponse findOne(Long scheduleId) {
        Schedule schedule = repository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("일정이 존재하지 않습니다.")
        );
        return new GetResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getAuthor()
        );
    }

    @Transactional(readOnly = true)
    public List<GetResponse> findAll() {
        List<Schedule> schedules = repository.findAll();

        List<GetResponse> dtos = new ArrayList<>();
        for (Schedule schedule : schedules) {
            GetResponse dto = new GetResponse(
                    schedule.getId(),
                    schedule.getTitle(),
                    schedule.getAuthor()

            );
            dtos.add(dto);
        }
        return dtos;

//        return schedules.stream()
//                .map(Schedule -> new GetResponse(
//                        schedule.getId(),
//                        schedule.getTitle(),
//                        schedule.getAuthor(),
//                        schedule.getcreatedAt(),
//                        schedule.getmodifiedAt()
//                        )).toList();
    }

    @Transactional
    public UpdateResponse update(Long scheduleId, UpdateResponse request) {
        Schedule schedule = repository.findById(scheduleId).orElseThrow(
                () -> new IllegalStateException("일정이 존재하지 않습니다.")
        );
        schedule.update(request.getTitle(), request.getAuthor());
        return new UpdateResponse(
                schedule.getTitle(),
                schedule.getAuthor()
        );
    }

    @Transactional
    public void delete(Long scheduleId) {
        boolean existence = repository.existsById(scheduleId);
        if (!existence) {
            throw new IllegalStateException("일정이 존재하지 않습니다.");
        }
        repository.deleteById(scheduleId);
    }


}
