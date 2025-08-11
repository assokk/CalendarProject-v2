package org.example.calendarproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.calendarproject.dto.UserSaveRequest;
import org.example.calendarproject.dto.UserSaveResponse;
import org.example.calendarproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserSaveResponse> saveUser (@RequestBody UserSaveRequest request) {
        return ResponseEntity.ok(userService.save(request));
    }
}
