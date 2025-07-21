package com.enigmacamp.assesment.mapper;

import com.enigmacamp.assesment.dto.respose.UserResponse;
import com.enigmacamp.assesment.entity.User;

public class UserMapper {
    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .username(user.getUsername())
                .birthDate(user.getBirthdate())
                .birthPlace(user.getBirthPlace())
                .build();
    }
}
