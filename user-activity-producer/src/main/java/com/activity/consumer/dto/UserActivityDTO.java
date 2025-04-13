package com.activity.consumer.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UserActivityDTO {
    private String userId;
    private String action;
    private LocalDateTime timestamp;
}