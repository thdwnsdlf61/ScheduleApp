package com.example.user.controller;

import com.example.user.dto.LoginRequestDto;
import com.example.user.dto.SignUpRequestDto;
import com.example.user.dto.UserResponseDto;
import com.example.user.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signUpAPI(@Validated @RequestBody SignUpRequestDto requestDto) {
        return new ResponseEntity<>(userService.signUp(requestDto), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDto> loginAPI(@Validated @RequestBody LoginRequestDto requestDto, HttpSession session) {
        UserResponseDto login = userService.login(requestDto);
        session.setAttribute("sessionKey", requestDto.getEmail());
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    // Read
    @GetMapping
    public ResponseEntity<List<UserResponseDto>> findAllUserAPI() {
        return new ResponseEntity<>(userService.findAllUser(), HttpStatus.OK);
    }

    // Update
//    @PatchMapping("/{userId}")
//    public ResponseEntity<UserResponseDto> updateUerAPI(@PathVariable Long userId, @RequestBody UserRequestDto requestDto) {
//        return new ResponseEntity<>(userService.updateUser(userId, requestDto), HttpStatus.OK);
//    }

    // Delete

}
