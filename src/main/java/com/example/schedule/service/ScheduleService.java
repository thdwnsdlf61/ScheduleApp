package com.example.schedule.service;

import com.example.schedule.dto.ScheduleResponseDto;
import com.example.schedule.entity.Schedule;
import com.example.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    public ScheduleService(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public ScheduleResponseDto save(String username, String todoTitle, String todoList) {

        Schedule schedule = new Schedule(username, todoTitle, todoList);

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new ScheduleResponseDto(savedSchedule.getId(), savedSchedule.getTodoTitle(), savedSchedule.getTodoList());
    }

    public List<ScheduleResponseDto> findAll() {

        return scheduleRepository.findAll()
                .stream()
                .map(ScheduleResponseDto::toDto)
                .toList();
    }

    public ScheduleResponseDto findById(Long id) {

        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if (optionalSchedule.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exists id = " + id);
        }
        Schedule findSchedule = optionalSchedule.get();

        return new ScheduleResponseDto(findSchedule.getId(), findSchedule.getTodoTitle(), findSchedule.getTodoList());
    }

    @Transactional
    public ScheduleResponseDto update(Long id, String todoTitle, String todoList) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        findSchedule.setTodoTitle(todoTitle);
        findSchedule.setTodoList(todoList);

        return new ScheduleResponseDto(id, todoTitle, todoList);
    }

    public void delete(Long id) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);

        scheduleRepository.delete(findSchedule);
    }
}
