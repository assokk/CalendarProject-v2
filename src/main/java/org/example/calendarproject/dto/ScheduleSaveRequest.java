package org.example.calendarproject.dto;

import lombok.Getter;
import org.example.calendarproject.entity.User;

@Getter
public class ScheduleSaveRequest {

    private String title;
    private String contents;
}
