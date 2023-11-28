package com.example.bookCartz.service;

import com.example.bookCartz.config.JwtService;
import com.example.bookCartz.controller.AuthenticationRequest;
import com.example.bookCartz.controller.AuthenticationResponse;
import com.example.bookCartz.controller.RegisterRequest;
import com.example.bookCartz.enums.Role;
import com.example.bookCartz.model.Book;
import com.example.bookCartz.model.User;
import com.example.bookCartz.model.UserCart;
import com.example.bookCartz.repository.UserRepository;
import lombok.RequiredArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


//    public AuthenticationService(UserRepository repository) {
//        this.repository = repository;
//    }

    public AuthenticationResponse register(RegisterRequest request) {
       var user = User.builder()
               .firstName(request.getFirstName())
               .lastName(request.getLastName())
               .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
               .role(request.getRole())
               .build();
       repository.save(user);
       var jwtToken = jwtService.generateToken(user);
       return AuthenticationResponse.builder()
               .token(jwtToken)
               .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(),
                request.getPassword()
        )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
