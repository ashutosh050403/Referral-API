package com.ashutosh.referralapi.controller;


import com.ashutosh.referralapi.dto.UserDto;
import com.ashutosh.referralapi.dto.ProfileDto;
import com.ashutosh.referralapi.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Valid @RequestBody UserDto userDto) {
        return ResponseEntity.ok(userService.signup(userDto));
    }

    @PostMapping("/complete-profile")
    public ResponseEntity<?> completeProfile(@Valid @RequestBody ProfileDto profileDto) {
        return ResponseEntity.ok(userService.completeProfile(profileDto));
    }
}
