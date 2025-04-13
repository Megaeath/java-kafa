package com.activity.consumer.controller;

import com.activity.consumer.dto.UserActivityDTO;
import com.activity.consumer.service.ActivityProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/activity")
@RequiredArgsConstructor
public class ActivityController {

    private final ActivityProducerService activityProducerService;

    @PostMapping
    public ResponseEntity<String> publishActivity(@RequestBody UserActivityDTO activityDTO) {
        activityDTO.setTimestamp(LocalDateTime.now());
        activityProducerService.sendActivity(activityDTO);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Activity logged and sent to Kafka");
    }
}