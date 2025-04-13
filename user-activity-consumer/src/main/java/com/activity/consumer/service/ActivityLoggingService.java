package com.activity.consumer.service;

import com.activity.consumer.entity.UserActivityLog;
import com.activity.consumer.repository.UserActivityLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ActivityLoggingService {

    private final UserActivityLogRepository activityLogRepository;

    public void logActivity(UserActivityLog activityLog) {
        log.info("Received user activity: {}", activityLog);
        // You can add more complex logging logic here,
        // such as formatting the log message differently.

        // If you want to persist to the database:
        activityLogRepository.save(activityLog);
        log.info("Activity saved to database: {}", activityLog);
    }
}