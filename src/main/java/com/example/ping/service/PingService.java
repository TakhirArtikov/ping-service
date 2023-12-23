package com.example.ping.service;

import com.example.ping.dto.PingDto;
import com.example.ping.dto.PingRequest;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;
import java.util.List;

public interface PingService {

    Page<PingDto> findAllPaginated(int pageNumber);

    List<PingDto> searchByParameters(PingRequest request);

}
