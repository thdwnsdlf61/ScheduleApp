package com.example.schedule.service;

import com.example.domain.User;
import com.example.schedule.dto.ScheduleRequestDto;
import com.example.schedule.dto.ScheduleResponseDto;
import com.example.domain.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import com.example.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Slf4j
@Service
public class ScheduleService {

    // 속성
    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 생성자
    public ScheduleService(ScheduleRepository scheduleRepository, UserRepository userRepository) {
        this.scheduleRepository = scheduleRepository;
        this.userRepository = userRepository;
    }

    // 기능
    // 생성
    public ScheduleResponseDto save(ScheduleRequestDto requestDto) {
        User user = userRepository.findByUserName(requestDto.getAuthor()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다. = " + requestDto.getAuthor()));
        Schedule schedule = new Schedule(requestDto, user);
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return toDto(savedSchedule);
    }

    // 조회(전체)
    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    // 조회(단건, id로 조회)
    public ScheduleResponseDto findById(Long scheduleId) {
        Schedule schedule = findScheduleById(scheduleId);
        return toDto(schedule);
    }

    // 수정
    public ScheduleResponseDto update(Long scheduleId, ScheduleRequestDto requestDto) {
        Schedule schedule = findScheduleById(scheduleId);
        schedule.updateSchedule(requestDto);
        scheduleRepository.save(schedule);

        return toDto(schedule);
    }

    // 삭제
    public void delete(Long scheduleId) {
        scheduleRepository.deleteById(scheduleId);
    }

    private Schedule findScheduleById(Long scheduleId) {
        return scheduleRepository.findById(scheduleId).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "id가 존재하지 않습니다. = " + scheduleId));

    }

    private ScheduleResponseDto toDto(Schedule schedule) {
        return ScheduleResponseDto.toDto(schedule);
    }
}
