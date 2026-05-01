package com.faizan.taskmanager.controller;

import com.faizan.taskmanager.config.JwtUtil;
import com.faizan.taskmanager.model.User;
import com.faizan.taskmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public User register(@RequestBody User user) {
        return userService.registerUser(user);
    }
    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User existingUser = userService.loginUser(user.getEmail(), user.getPassword());

        return jwtUtil.generateToken(existingUser.getEmail());
    }
    @GetMapping("/api/test")
    public String test() {
        return "Protected API Working!";
    }
}