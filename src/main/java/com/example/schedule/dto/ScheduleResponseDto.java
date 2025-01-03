package com.example.schedule.dto;

import com.example.domain.Schedule;
import com.example.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {
    private final Long scheduleId;
    private final String author;
    private final String title;
    private final String contents;
    private final LocalDateTime createdDate;
    private final LocalDateTime modifiedDate;

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return new ScheduleResponseDto(
                schedule.getScheduleId(),
                schedule.getAuthor().getUserName(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedDate(),
                schedule.getModifiedDate()
        );
    }
}
