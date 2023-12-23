package com.example.ping.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PingRequest {
    private String domain;
    private String ipAddress;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private int testStatus;

}
