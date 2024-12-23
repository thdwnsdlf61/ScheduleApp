package com.example.schedule.dto;

import com.example.schedule.entity.Schedule;
import lombok.Getter;

@Getter
public class ScheduleResponseDto {

    private final Long id;

    private final String todoTitle;

    private final String todoList;

    public ScheduleResponseDto(Long id, String todoTitle, String todoList) {
        this.id = id;
        this.todoTitle = todoTitle;
        this.todoList = todoList;
    }

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(schedule.getId(), schedule.getTodoTitle(), schedule.getTodoList());
    }
}
