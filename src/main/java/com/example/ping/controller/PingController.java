package com.example.ping.controller;

import com.example.ping.dto.PingDto;
import com.example.ping.dto.PingRequest;
import com.example.ping.service.PingService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PingController {
    private final PingService service;



    @GetMapping("/ping/paginated/{pageNumber}")
    public String findAllPaginated(@PathVariable(name = "pageNumber") int pageNumber,Model model) {
        Page<PingDto> paginatedPings = service.findAllPaginated(pageNumber);
        model.addAttribute("pingDtoList", paginatedPings.getContent());
        model.addAttribute("totalPages", paginatedPings.getTotalPages());
        return "ping-paginated-template";
    }


    @PostMapping("/ping-search")
    public String search(@RequestBody PingRequest request, Model model) {
        List<PingDto> pingDtoList = service.searchByParameters(request);
        model.addAttribute("pingDtoList", pingDtoList);

        return "ping-detail-template";
    }
}

