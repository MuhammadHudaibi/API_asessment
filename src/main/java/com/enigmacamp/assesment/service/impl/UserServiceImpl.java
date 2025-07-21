package com.enigmacamp.assesment.service.impl;

import com.enigmacamp.assesment.constant.UserRole;
import com.enigmacamp.assesment.dto.request.UserRequest;
import com.enigmacamp.assesment.dto.respose.UserResponse;
import com.enigmacamp.assesment.entity.User;
import com.enigmacamp.assesment.mapper.UserMapper;
import com.enigmacamp.assesment.repository.UserRepository;
import com.enigmacamp.assesment.security.JwtUtils;
import com.enigmacamp.assesment.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        user.setBirthdate(userRequest.getBirthDate());
        user.setBirthPlace(userRequest.getBirthPlace());
        user.setRole(UserRole.ROLE_USER);

        userRepository.save(user);

        return UserMapper.toUserResponse(user);
    }

    @Override
    public String loginUser(UserRequest userRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userRequest.getUsername(),
                        userRequest.getPassword()
                ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        return jwtUtils.generateToken(authentication);
    }
}
