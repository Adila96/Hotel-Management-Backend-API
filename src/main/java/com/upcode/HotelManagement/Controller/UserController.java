package com.upcode.HotelManagement.Controller;

import com.upcode.HotelManagement.Dto.JwtAuthenticationResponse;
import com.upcode.HotelManagement.Dto.SignInRequest;
import com.upcode.HotelManagement.Dto.SignUpRequest;
import com.upcode.HotelManagement.Model.Role;
import com.upcode.HotelManagement.Model.Users;
import com.upcode.HotelManagement.Repository.UserRepository;
import com.upcode.HotelManagement.Services.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/users")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    ResponseEntity<?> showAllUsers(){
        System.out.println("Show All Users");
        return ResponseEntity.ok(userRepository.findAll());
    }

    @PostMapping("/login")
    JwtAuthenticationResponse authenticateUser(@RequestBody SignInRequest signInRequest){
        return authenticationService.signin(signInRequest);
    }

    @PostMapping("/signUp")
    JwtAuthenticationResponse registerUser(@RequestBody SignUpRequest signUpRequest){
        System.out.println(signUpRequest);
        return authenticationService.signup(signUpRequest);
    }
}
