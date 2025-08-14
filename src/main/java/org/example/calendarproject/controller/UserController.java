package org.example.calendarproject.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.calendarproject.dto.*;
import org.example.calendarproject.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/users/signup")
    public ResponseEntity<UserSaveResponse> signup (@RequestBody UserSaveRequest request) {
        return ResponseEntity.ok(userService.signup(request));
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> getUsers() {
        return ResponseEntity.ok(userService.findAllUsers());
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable long id) {
        return ResponseEntity.ok(userService.findUserById(id));
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UserUpdateResponse> updateUser(@PathVariable long id, @RequestBody UserUpdateRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id) {
        userService.deleteUser(id);
    }


    @PostMapping("/users/login")
    public ResponseEntity<Void> login(@RequestBody UserLoginRequest request, HttpSession session) {
        boolean ok = userService.login(request, session);
        if (ok) return ResponseEntity.ok().build();
        return ResponseEntity.status(401).build();
    }
}
