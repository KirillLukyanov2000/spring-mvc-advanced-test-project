package ru.lukyanov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class HomePageController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getHomePage() {
        System.out.println("Controller HomePageController is working");
        return "redirect:/users/";
    }

}