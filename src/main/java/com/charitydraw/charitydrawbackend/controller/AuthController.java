package com.charitydraw.charitydrawbackend.controller;

import com.charitydraw.charitydrawbackend.dto.LoginRequest;
import com.charitydraw.charitydrawbackend.entity.User;
import com.charitydraw.charitydrawbackend.security.JwtUtil;
import com.charitydraw.charitydrawbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;
    @PostMapping("/signup")
    public Map<String, Object> signup(@RequestBody User user){
        User savedUser = authService.register(user);

        String token = jwtUtil.generateToken(savedUser.getEmail());

        return Map.of(
                "token", token,
                "user", savedUser
        );
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        try {
            User user = authService.login(request);

            String token = jwtUtil.generateToken(user.getEmail());

            return ResponseEntity.ok(
                    Map.of(
                            "token", token,
                            "user", user
                    )
            );
        } catch (Exception e) {
            return ResponseEntity
                    .status(401)
                    .body(Map.of("error", "Invalid credentials"));
        }
    }
}