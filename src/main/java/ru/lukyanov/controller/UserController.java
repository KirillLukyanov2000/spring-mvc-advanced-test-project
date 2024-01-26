package ru.lukyanov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ru.lukyanov.entity.User;
import ru.lukyanov.service.UserService;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/")
    public ModelAndView showAllUsers(ModelAndView modelAndView) {

        System.out.println("Controller UserController method showAllUsers is working");

        modelAndView.addObject("users", userService.findAll());

        modelAndView.setViewName("userpage");
        return modelAndView;
    }

    @GetMapping("/{id}")
    public ModelAndView showOneUserAndUsers(ModelAndView modelAndView, @PathVariable Long id) {
        Optional<User> optionalUserById = userService.findById(id);
        if (optionalUserById.isPresent()) {
            modelAndView.addObject("user", optionalUserById.get());
            modelAndView.addObject("users", userService.findAll());
            modelAndView.setViewName("userpage");
        } else {
            System.out.println("No such User found, please enter valid User id");
            modelAndView.setViewName("redirect:http://www.google.com");
        }

        return modelAndView;
    }

    @PostMapping
    public String createOrLoginUser(ModelAndView modelAndView,
                                    User user,
                                    @RequestParam(required = false) String createUser, String loginUser) {

        modelAndView.setViewName("userpage");
        if (Objects.nonNull(createUser)) {
            userService.save(user);
            return "redirect:/users/%d".formatted(user.getId());
        } else {
            if (Objects.nonNull(loginUser)) {

                System.out.println("User logged on with login: " + user.getLogin());

            }
            return "redirect:/users/";
        }
    }

    @PostMapping("/{id}")
    public String updateOrDeleteUser(ModelAndView view,
                                     User user,
                                     @RequestParam(required = false) String deleteUser) {
        view.setViewName("userpage");
        if (Objects.nonNull(deleteUser)) {
            userService.delete(user);
            return "redirect:/";
        } else {
            userService.update(user);
            return "redirect:/users/%d/".formatted(user.getId());
        }
    }

}