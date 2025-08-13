package org.example.calendarproject.dto;

import lombok.Getter;

@Getter
public class UserUpdateRequest {

    private String username;
    private String password;
    private String email;
}
