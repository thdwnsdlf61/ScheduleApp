package com.example.domain;

import com.example.schedule.dto.ScheduleRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Entity
@Table(name = "schedule")
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scheduleId;

    @ManyToOne
    @JoinColumn(name = "userid")
    private User author;

    @Column
    @Setter
    private String title;

    @Column(columnDefinition = "longtext")
    @Setter
    private String contents;

    public void updateSchedule(ScheduleRequestDto requestDto) {
        if (requestDto.getTitle() != null) {
            this.title = requestDto.getTitle();
        }
        if (requestDto.getContents() != null) {
            this.contents = requestDto.getContents();
        }
    }

    public Schedule(ScheduleRequestDto requestDto, User user) {
        this.title = requestDto.getTitle();
        this.author = user;
        this.contents = requestDto.getContents();
    }
}
