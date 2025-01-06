package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    // field
    private final ScheduleService scheduleService;

    // constructor
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // method
    // Create
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createScheduleAPI(@RequestBody ScheduleRequestDto requestDto, HttpSession session) {
        Long userId = (Long) session.getAttribute("userId");
        return new ResponseEntity<>(scheduleService.createSchedule(requestDto, session), HttpStatus.CREATED);
    }

    // Read(전체)
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllScheduleAPI() {

        return new ResponseEntity<>(scheduleService.findAllSchedule(), HttpStatus.OK);
    }

    // Read(단건, id로 조회)
    @GetMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long scheduleId) {

        return new ResponseEntity<>(scheduleService.findById(scheduleId), HttpStatus.OK);
    }

    // Update
    @PatchMapping("/{scheduleId}")
    public ResponseEntity<ScheduleResponseDto> updateScheduleAPI(@PathVariable Long scheduleId, @RequestBody ScheduleRequestDto requestDto) {

        return new ResponseEntity<>(scheduleService.updateSchedule(scheduleId, requestDto), HttpStatus.OK);
    }


    // Delete
    @DeleteMapping("/{scheduleId}")
    public ResponseEntity<Void> deleteScheduleAPI(@PathVariable Long scheduleId) {
        scheduleService.deleteSchedule(scheduleId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
