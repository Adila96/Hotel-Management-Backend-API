package com.upcode.HotelManagement.Configuration;

import com.upcode.HotelManagement.Model.Role;
import com.upcode.HotelManagement.Model.Users;
import com.upcode.HotelManagement.Repository.UserRepository;
import com.upcode.HotelManagement.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SeedDataConfig implements CommandLineRunner {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @Override
    public void run(String... args) throws Exception {

        if (userRepository.count() == 0) {

            Users admin = Users
                    .builder()
                    .name("admin")
                    .email("admin@admin.com")
                    .password(passwordEncoder.encode("password"))
                    .role(Role.ROLE_ADMIN)
                    .build();

            userService.save(admin);
            System.out.println("created ADMIN user - {} "+admin);
        }
    }
}
