package com.example.schedule.controller;

import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
public class ScheduleController {

    // 속성
    private final ScheduleService scheduleService;

    // 생성자
    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    // 기능
    // 생성 Create
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto requestDto) {

        return new ResponseEntity<>(scheduleService.save(requestDto), HttpStatus.CREATED);
    }

    // 조회 Read(전체)
    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAll() {

        return new ResponseEntity<>(scheduleService.findAll(), HttpStatus.OK);
    }

    // 조회 Read(단건, id로 조회)
    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findById(@PathVariable Long scheduleId) {

        return new ResponseEntity<>(scheduleService.findById(scheduleId), HttpStatus.OK);
    }

    // 수정 Update
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(@PathVariable Long scheduleId,@RequestBody ScheduleRequestDto requestDto) {

        return new ResponseEntity<>(scheduleService.update(scheduleId, requestDto), HttpStatus.OK);
    }


    // 삭제 Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long scheduleId) {
        scheduleService.delete(scheduleId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
