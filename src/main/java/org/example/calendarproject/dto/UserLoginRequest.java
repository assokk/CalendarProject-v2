package org.example.calendarproject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserLoginRequest {
    private String email;
    private String password;
}
