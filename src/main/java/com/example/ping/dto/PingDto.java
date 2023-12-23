package com.example.ping.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class PingDto {
    private Long id;
    private String ipAddress;
    private String domain;
    private LocalDateTime checkDate;
    private int testStatus;
    private String pingResult;
}
