package org.example.calendarproject.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleUpdateResponse {

    private final Long id;
    private final String title;
    private final String contents;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public ScheduleUpdateResponse(Long id, String title, String contents, String author, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
