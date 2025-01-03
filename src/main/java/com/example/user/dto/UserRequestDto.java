package com.example.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class UserRequestDto {
    private final String userName;
    private final String email;
}
