package com.enigmacamp.assesment.controller;

import com.enigmacamp.assesment.dto.request.UserRequest;
import com.enigmacamp.assesment.dto.respose.UserResponse;
import com.enigmacamp.assesment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/create-user")
    public UserResponse createUser(@RequestBody UserRequest user) {
        return userService.createUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody UserRequest user) {
        return userService.loginUser(user);
    }
}
