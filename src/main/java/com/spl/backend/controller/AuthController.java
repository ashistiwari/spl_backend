package com.spl.backend.controller;

import com.spl.backend.auth.AuthService;
import com.spl.backend.dto.AuthResponse;
import com.spl.backend.dto.LoginRequest;
import com.spl.backend.dto.SignUpRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private AuthService authService;
    @PostMapping("/signup")
    public AuthResponse signup(@RequestBody SignUpRequest request){
        return authService.signup(request);
    }
    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequest request) {
        return authService.login(request);
    }

}
