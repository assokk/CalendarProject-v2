package org.example.calendarproject.service;

import lombok.RequiredArgsConstructor;
import org.example.calendarproject.dto.UserSaveRequest;
import org.example.calendarproject.dto.UserSaveResponse;
import org.example.calendarproject.entity.User;
import org.example.calendarproject.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponse save(UserSaveRequest userSaveRequest) {
        User user = new User(userSaveRequest.getUsername(), userSaveRequest.getEmail());
        User savedUser = userRepository.save(user);
        return new UserSaveResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }
}
