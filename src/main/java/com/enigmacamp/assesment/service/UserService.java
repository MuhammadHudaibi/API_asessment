package com.enigmacamp.assesment.service;

import com.enigmacamp.assesment.dto.request.LoginRequest;
import com.enigmacamp.assesment.dto.request.UserRequest;
import com.enigmacamp.assesment.dto.respose.LoginResponse;
import com.enigmacamp.assesment.dto.respose.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    LoginResponse loginUser(LoginRequest userRequest);
}
