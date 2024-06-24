package com.example.FileStorageSystem.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.FileStorageSystem.model.User;
import com.example.FileStorageSystem.service.UserService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {
        userService.save(user);
    }

    @GetMapping("/user/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
    }
}
