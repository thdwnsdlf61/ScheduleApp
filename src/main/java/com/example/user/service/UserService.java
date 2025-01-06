package com.example.user.service;

import com.example.domain.User;
import com.example.user.dto.LoginRequestDto;
import com.example.user.dto.SignUpRequestDto;
import com.example.user.dto.UserResponseDto;
import com.example.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create user
    public UserResponseDto signUp(SignUpRequestDto requestDto) {
        User user = new User(requestDto.getUserName(), requestDto.getEmail(), requestDto.getPassword());
        User saveUser = userRepository.save(user);
        return toDto(saveUser);
    }

    public UserResponseDto login(LoginRequestDto requestDto) {
        User email = userRepository.findByEmail(requestDto.getEmail()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다. = " + requestDto.getEmail()));
        if (!requestDto.getPassword().equals(email.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        return toDto(email);
    }

    // Read user
    public List<UserResponseDto> findAllUser() {
        return userRepository.findAll()
                .stream()
                .map(UserResponseDto::toDto)
                .toList();
    }

    private UserResponseDto toDto(User user) {
        return UserResponseDto.toDto(user);
    }
}
