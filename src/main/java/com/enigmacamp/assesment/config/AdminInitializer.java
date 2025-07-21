package com.enigmacamp.assesment.config;

import com.enigmacamp.assesment.constant.UserRole;
import com.enigmacamp.assesment.entity.User;
import com.enigmacamp.assesment.repository.UserRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class AdminInitializer {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostConstruct
    @Transactional
    public void initAdmin() {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User user = User.builder()
                    .name("Admin")
                    .username("admin")
                    .password(passwordEncoder.encode("admin"))
                    .role(UserRole.ROLE_ADMIN)
                    .build();

            userRepository.save(user);

            System.out.println("Admin has been created. username: " + user.getUsername() + " password: admin");
        }
    }
}
