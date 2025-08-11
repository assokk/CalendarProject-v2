package org.example.calendarproject.service;

import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.calendarproject.dto.ScheduleResponse;
import org.example.calendarproject.dto.ScheduleSaveRequest;
import org.example.calendarproject.dto.ScheduleSaveResponse;
import org.example.calendarproject.entity.Schedule;
import org.example.calendarproject.repository.ScheduleRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    @Transactional
    public ScheduleSaveResponse save(ScheduleSaveRequest scheduleSaveRequest) {
        Schedule schedule = new Schedule(scheduleSaveRequest.getTitle(), scheduleSaveRequest.getContents(), scheduleSaveRequest.getAuthor(), scheduleSaveRequest.getPassword());
        Schedule savedSchedule = scheduleRepository.save(schedule);
        return new ScheduleSaveResponse(
                savedSchedule.getId(),
                savedSchedule.getTitle(),
                savedSchedule.getContents(),
                savedSchedule.getAuthor(),
                savedSchedule.getCreatedAt(),
                savedSchedule.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<ScheduleResponse> findSchedules(String author) {
        List<Schedule> schedules = scheduleRepository.findAll();
        List<ScheduleResponse> scheduleResponses = new ArrayList<>();

        if(author == null) {
            for (Schedule schedule : schedules) {
                scheduleResponses.add(new ScheduleResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContents(),
                        schedule.getAuthor(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ));
            }
            return scheduleResponses;
        }

        for (Schedule schedule : schedules) {
            if(author.equals(schedule.getAuthor())) {
                scheduleResponses.add(new ScheduleResponse(
                        schedule.getId(),
                        schedule.getTitle(),
                        schedule.getContents(),
                        schedule.getAuthor(),
                        schedule.getCreatedAt(),
                        schedule.getModifiedAt()
                ));
            }
        }
        return scheduleResponses;
    }

    @Transactional(readOnly = true)
    public ScheduleResponse findScheduleById(long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public ScheduleResponse updateSchedule(long id, ScheduleSaveRequest request) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        if (!ObjectUtils.nullSafeEquals(schedule.getPassword(), request.getPassword())) {
            throw new IllegalArgumentException("Password doesn't match");
        }
        schedule.updateTitleAndAuthor(request.getTitle(), request.getAuthor());

        return new ScheduleResponse(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getAuthor(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    @Transactional
    public void deleteSchedule(long id, String password) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Schedule not found")
        );
        if (!ObjectUtils.nullSafeEquals(schedule.getPassword(), password)) {
            throw new IllegalArgumentException("Password doesn't match");
        }
        scheduleRepository.deleteById(id);
    }
}
