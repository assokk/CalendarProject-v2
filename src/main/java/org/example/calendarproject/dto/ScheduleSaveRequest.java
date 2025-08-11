package org.example.calendarproject.dto;

import lombok.Getter;

@Getter
public class ScheduleSaveRequest {

    private String title;
    private String contents;
    private String author;
    private String password;

}
