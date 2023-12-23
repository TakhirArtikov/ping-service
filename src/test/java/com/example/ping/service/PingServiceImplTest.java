package com.example.ping.service;

import com.example.ping.dto.PingDto;
import com.example.ping.dto.PingRequest;
import com.example.ping.entity.Ping;
import com.example.ping.repository.PingRepository;
import com.example.ping.service.impl.PingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class PingServiceImplTest {
    @Mock
    private PingRepository repository;

    @InjectMocks
    private PingServiceImpl pingService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testFindAllPaginated() {
        List<Ping> mockPingList = Collections.singletonList(new Ping("example.com", "192.168.1.1", LocalDateTime.now(), LocalDateTime.now(), "success"));
        Page<Ping> mockPage = new PageImpl<>(mockPingList);
        when(repository.findAll(any(PageRequest.class))).thenReturn(mockPage);

        Page<PingDto> result = pingService.findAllPaginated(0);

        assertEquals(mockPingList.size(), result.getContent().size());
    }

    @Test
    void testSearchByParameters() {
        List<Ping> mockPingList = Collections.singletonList(new Ping("example.com", "192.168.1.1", LocalDateTime.now().minusDays(1), LocalDateTime.now(), 200));
        when(repository.searchByParameters(anyString(), anyString(), any(LocalDateTime.class), any(LocalDateTime.class), anyInt())).thenReturn(mockPingList);

        LocalDateTime startDate = LocalDateTime.now().minusDays(1);
        LocalDateTime endDate = LocalDateTime.now();
        String domain = "example.com";
        String ipAddress = "192.168.1.1";
        int testStatus = 200;

        PingRequest mockRequest = new PingRequest(domain, ipAddress, startDate, endDate, testStatus);
        List<PingDto> result = pingService.searchByParameters(mockRequest);

        assertEquals(mockPingList.size(), result.size());


    }
}

