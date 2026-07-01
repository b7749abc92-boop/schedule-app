package com.example.scheduleapp.threelayer;

import com.example.scheduleapp.dto.CreateRequest;
import com.example.scheduleapp.dto.CreateResponse;
import com.example.scheduleapp.dto.GetResponse;
import com.example.scheduleapp.dto.UpdateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service scheduleSvc;

    @PostMapping("/schedules")
    public ResponseEntity<CreateResponse> creat(@RequestBody CreateRequest request) {
        CreateResponse result = scheduleSvc.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping("/schedules/{/scheduleId}")
    public ResponseEntity<GetResponse> getOne(@PathVariable Long scheduleId) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleSvc.findOne(scheduleId));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<GetResponse>> getAll() {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleSvc.findAll());
    }

    @PatchMapping("/schedules/{/scheduleId}")
    public ResponseEntity<UpdateResponse> update(@PathVariable Long scheduleId, @RequestBody UpdateResponse request) {
        return ResponseEntity.status(HttpStatus.OK).body(scheduleSvc.update(scheduleId, request));
    }

    @DeleteMapping("/schedules/{/scheduleId}")
    public ResponseEntity<Void> delete(@PathVariable Long scheduleId) {
        scheduleSvc.delete(scheduleId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
