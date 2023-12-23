package com.example.ping.service.impl;

import com.example.ping.dto.PingDto;
import com.example.ping.dto.PingRequest;
import com.example.ping.entity.Ping;
import com.example.ping.repository.PingRepository;
import com.example.ping.service.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class PingServiceImpl implements PingService {
    private final PingRepository repository;

    @Override
    public Page<PingDto> findAllPaginated(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 5);
        return repository.findAll(pageable).map(this::convertToDto);
    }

    @Override
    public List<PingDto> searchByParameters(PingRequest request) {
        return repository.searchByParameters(request.getDomain(),request.getIpAddress(),
                        request.getStartDate(),request.getEndDate(),request.getTestStatus())
                .stream().map(this::convertToDto).toList();

    }


    private PingDto convertToDto(Ping ping) {
        PingDto pingDto = new PingDto();
        BeanUtils.copyProperties(ping,pingDto);
        return pingDto;
    }
}
