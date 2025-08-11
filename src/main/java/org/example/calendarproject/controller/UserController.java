package org.example.calendarproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.calendarproject.dto.UserResponse;
import org.example.calendarproject.dto.UserSaveRequest;
import org.example.calendarproject.dto.UserSaveResponse;
import org.example.calendarproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users")
    public ResponseEntity<UserSaveResponse> saveUser (@RequestBody UserSaveRequest request) {
        return ResponseEntity.ok(userService.save(request));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }
}
