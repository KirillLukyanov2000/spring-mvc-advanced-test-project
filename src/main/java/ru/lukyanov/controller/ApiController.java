package ru.lukyanov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.lukyanov.entity.User;
import ru.lukyanov.service.UserService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/json*")
public class ApiController {

    private final UserService userService;

    @GetMapping("/{id}")
    public String giveMeJson(Model model, @PathVariable Long id) {
        User user = userService.findById(id).orElseThrow();
        model.addAttribute("UserId", user.getId());
        model.addAttribute("UserLogin", user.getLogin());
        model.addAttribute("UserPassword", user.getPassword());


        return "jsonMapper";
    }
}