package com.example.user.dto;

import com.example.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class UserResponseDto {
    private final Long userId;
    private final String userName;
    private final String email;
    private final LocalDateTime createdDate;

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(
                user.getUserId(),
                user.getUserName(),
                user.getEmail(),
                user.getCreatedDate()
        );
    }
}
