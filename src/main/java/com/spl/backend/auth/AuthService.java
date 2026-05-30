package com.spl.backend.auth;

import com.spl.backend.dto.AuthResponse;
import com.spl.backend.dto.LoginRequest;
import com.spl.backend.dto.SignUpRequest;
import com.spl.backend.entity.User;
import com.spl.backend.repo.UserRepository;
import com.spl.backend.security.JwtService;
import io.swagger.v3.oas.annotations.servers.Server;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private UserRepository userRepository;
    private JwtService jwtService;
    private PasswordEncoder passwordEncoder;
    private AuthenticationManager authenticationManager;

    public AuthResponse signup(SignUpRequest request) {
        if (userRepository.findByEmailId(request.getEmail()).isPresent()) {
            throw new RuntimeException("user already exist with this emailId");
        }
        User user = User.builder()
                .name(request.getName())
                        .emailId(request.getEmail())
                                .password(request.getPassword()).build();
        userRepository.save(user);
        String token=jwtService.generateToken(user.getEmailId());
        return  new AuthResponse(token,user.getName(),user.getEmailId());
    }

    public AuthResponse login(LoginRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmailId(),request.getPassword()));
    User user=userRepository.findByEmailId(request.getEmailId()).orElseThrow();
    String token=jwtService.generateToken(user.getEmailId());
    return new AuthResponse(user.getEmailId(), user.getPassword(), token);
    }
}
