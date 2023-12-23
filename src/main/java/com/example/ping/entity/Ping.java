package com.example.ping.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "ping_requests")
public class Ping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ipAddress;
    private String domain;
    private LocalDateTime checkDate;
    private int testStatus;
    private String pingResult;


    public Ping(String s, String s1, LocalDateTime now, LocalDateTime now1, String success) {
    }

    public Ping(String s, String s1, LocalDateTime now, LocalDateTime now1, int i) {

    }
}
