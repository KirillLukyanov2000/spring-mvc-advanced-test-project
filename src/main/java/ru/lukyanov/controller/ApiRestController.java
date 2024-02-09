package ru.lukyanov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.lukyanov.entity.User;
import ru.lukyanov.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class ApiRestController {
    UserService userService;

    @Autowired
    public ApiRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public List<User> getAllUsers() {
        return userService.findAll();
    }
}
