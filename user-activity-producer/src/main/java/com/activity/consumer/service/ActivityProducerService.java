package com.activity.consumer.service;

import com.activity.consumer.dto.UserActivityDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityProducerService {

    private final KafkaTemplate<String, UserActivityDTO> kafkaTemplate;

    @Value("${kafka.topic.user-activity}")
    private String topicName;

    public void sendActivity(UserActivityDTO activity) {
        log.info("Sending activity {} to topic {}", activity, topicName);
        kafkaTemplate.send(topicName, activity.getUserId(), activity);
    }
}