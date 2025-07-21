package com.enigmacamp.assesment.service;

import com.enigmacamp.assesment.dto.request.UserRequest;
import com.enigmacamp.assesment.dto.respose.UserResponse;

public interface UserService {
    UserResponse createUser(UserRequest userRequest);
    String loginUser(UserRequest userRequest);
}
