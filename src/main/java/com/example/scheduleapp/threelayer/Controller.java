package com.example.scheduleapp.threelayer;

import com.example.scheduleapp.dto.CreateRequest;
import com.example.scheduleapp.dto.CreateResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final Service scheduleSvc;

    @PostMapping("/schedules")
    public ResponseEntity<CreateResponse> creat(@RequestBody CreateRequest request) {
        CreateResponse result = Service.save(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }
}
