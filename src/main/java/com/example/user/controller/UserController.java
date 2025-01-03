package com.example.user.controller;

import com.example.user.dto.UserRequestDto;
import com.example.user.dto.UserResponseDto;
import com.example.user.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    // field
    private final UserService userService;

    // constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // method
    // Create
    @PostMapping
    public ResponseEntity<UserResponseDto> createUserAPI(@RequestBody UserRequestDto requestDto) {
        return new ResponseEntity<>(userService.createService(requestDto.getUserName(), requestDto.getEmail()), HttpStatus.CREATED);
    }
}
