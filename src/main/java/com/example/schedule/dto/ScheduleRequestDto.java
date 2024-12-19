package com.example.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {

    private final String username;

    private final String todoTitle;

    private final String todoList;

    public ScheduleRequestDto(String username, String todoTitle, String todoList) {
        this.username = username;
        this.todoTitle = todoTitle;
        this.todoList = todoList;
    }
}
