package com.charitydraw.charitydrawbackend.controller;

import com.charitydraw.charitydrawbackend.entity.User;
import com.charitydraw.charitydrawbackend.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody User user){
        User saveduser=authService.register(user);
        return  ResponseEntity.ok("User registered successfully :"  + saveduser);

    }
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody User user){
//        User loggeduser=authService.login(user.getEmail(), user.getPassword());
//        return ResponseEntity.ok("User logged successfully"+loggeduser);
//    }
@PostMapping("/login")
public String login(@RequestBody User user) {
    return authService.login(user.getEmail(), user.getPassword());
}
}
