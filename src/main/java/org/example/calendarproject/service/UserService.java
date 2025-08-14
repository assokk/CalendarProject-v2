package org.example.calendarproject.service;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.calendarproject.dto.*;
import org.example.calendarproject.entity.User;
import org.example.calendarproject.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public UserSaveResponse signup(UserSaveRequest userSaveRequest) {
        User user = new User(userSaveRequest.getUsername(), userSaveRequest.getPassword(), userSaveRequest.getEmail());
        User savedUser = userRepository.save(user);
        return new UserSaveResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                savedUser.getCreatedAt(),
                savedUser.getModifiedAt()
        );
    }

    @Transactional(readOnly = true)
    public List<UserResponse> findAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = new ArrayList<>();

        for (User user : users) {
                userResponses.add(new UserResponse(
                        user.getId(),
                        user.getUsername(),
                        user.getEmail(),
                        user.getCreatedAt(),
                        user.getModifiedAt()
                ));
            }
        return userResponses;
    }

    @Transactional(readOnly = true)
    public UserResponse findUserById(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with id " + id + " not found")
        );
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional
    public UserUpdateResponse updateUser(Long id, UserUpdateRequest request) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with id " + id + " not found")
        );

        user.updateNameOrEmail(request.getUsername(), request.getEmail());

        return new UserUpdateResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getCreatedAt(),
                user.getModifiedAt()
        );
    }

    @Transactional
    public void deleteUser(long id) {
        User user = userRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("User with id " + id + " not found")
        );

        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public boolean login(UserLoginRequest request, HttpSession session) {
        User user = userRepository.findByEmail(request.getEmail()).orElse(null);
        if (user == null) return false;
        if (!user.getPassword().equals(request.getPassword())) return false;

        session.setAttribute("loginUserId", user.getId());
        return true;
    }
}
