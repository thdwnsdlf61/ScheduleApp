package com.example.user.service;

import com.example.domain.User;
import com.example.user.dto.UserResponseDto;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create user
    public UserResponseDto createUser(String userName, String email) {
        User user = new User(userName, email);
        User saveUser = userRepository.save(user);
        return toDto(saveUser);
    }

    // Read user
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    public UserResponseDto findUserById(Long userId) {
        User user = userRepository.findByUserId(userId);
        return toDto(user);
    }

    // Update user

    // Delete user

    private UserResponseDto toDto(User user) {
        return UserResponseDto.toDto(user);
    }
}
