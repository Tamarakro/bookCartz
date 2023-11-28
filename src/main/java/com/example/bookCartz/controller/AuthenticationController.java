package com.example.bookCartz.controller;

import com.example.bookCartz.dtos.request.AuthenticationRequest;
import com.example.bookCartz.dtos.request.RegisterRequest;
import com.example.bookCartz.dtos.response.AuthenticationResponse;
import com.example.bookCartz.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService authenticationService;

//    public AuthenticationController(AuthenticationService authenticationService) {
//        this.authenticationService = authenticationService;
//    }

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody RegisterRequest request){
    return ResponseEntity.ok(authenticationService.register(request));
}
    @PostMapping("/authentication")
    public ResponseEntity<AuthenticationResponse>register(@RequestBody AuthenticationRequest request){
        return ResponseEntity.ok(authenticationService.authenticate(request));
    }
}
