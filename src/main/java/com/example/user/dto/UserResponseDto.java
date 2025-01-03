package com.example.user.dto;

import com.example.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private final String userName;
    private final String email;
    private final LocalDateTime createdDate;

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getUserName(),
                user.getEmail(),
                user.getCreatedDate()
        );
    }
}
