package org.example.calendarproject.controller;

import lombok.RequiredArgsConstructor;
import org.example.calendarproject.dto.ScheduleResponse;
import org.example.calendarproject.dto.ScheduleSaveRequest;
import org.example.calendarproject.dto.ScheduleSaveResponse;
import org.example.calendarproject.service.ScheduleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/schedules")
    public ResponseEntity<ScheduleSaveResponse> saveSchedule (@RequestBody ScheduleSaveRequest request) {
        return ResponseEntity.ok(scheduleService.save(request));
    }

    @GetMapping("/schedules")
    public ResponseEntity<List<ScheduleResponse>> getSchedules(@RequestParam String author) {
        return ResponseEntity.ok(scheduleService.findSchedules(author));
    }

    @GetMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponse> findScheduleById(@PathVariable long id) {
        return ResponseEntity.ok(scheduleService.findScheduleById(id));
    }

    @PutMapping("/schedules/{id}")
    public ResponseEntity<ScheduleResponse> updateSchedule(@PathVariable long id, @RequestBody ScheduleSaveRequest request) {
        return ResponseEntity.ok(scheduleService.updateSchedule(id, request));
    }

    @DeleteMapping("/schedules/{id}")
    public void deleteSchedule(@PathVariable long id, @RequestParam String password) {
        scheduleService.deleteSchedule(id, password);
    }
}
