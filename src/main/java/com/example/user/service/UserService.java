package com.example.user.service;

import com.example.domain.User;
import com.example.user.dto.UserRequestDto;
import com.example.user.dto.UserResponseDto;
import com.example.user.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // create user
    public UserResponseDto createService(String userName, String email) {
        User user = new User(userName, email);
        User saveUser = userRepository.save(user);
        return toDto(saveUser);
    }

    private UserResponseDto toDto(User user) {
        return UserResponseDto.toDto(user);
    }
}
