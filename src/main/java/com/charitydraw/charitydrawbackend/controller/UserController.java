package com.charitydraw.charitydrawbackend.controller;

import com.charitydraw.charitydrawbackend.entity.User;
import com.charitydraw.charitydrawbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
//@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}