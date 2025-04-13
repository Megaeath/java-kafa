package com.activity.consumer.listener;


import com.activity.consumer.entity.UserActivityLog;
import com.activity.consumer.service.ActivityLoggingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class UserActivityConsumer {

    private final ActivityLoggingService activityLoggingService;

    @KafkaListener(topics = "${kafka.topic.user-activity}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(UserActivityLog activityLog) {
        log.info("Consuming message: {}", activityLog);
        activityLoggingService.logActivity(activityLog);
    }
}