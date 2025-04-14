package com.tecnologiaefinancas.foodiesapi.controller;

import com.tecnologiaefinancas.foodiesapi.io.UserRequest;
import com.tecnologiaefinancas.foodiesapi.io.UserResponse;
import com.tecnologiaefinancas.foodiesapi.service.UserService;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse register(@RequestBody UserRequest request) {
        return userService.registerUser(request);
    }
}
