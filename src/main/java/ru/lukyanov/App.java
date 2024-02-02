package ru.lukyanov;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.lukyanov.entity.User;
import ru.lukyanov.service.UserService;

import java.util.List;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class, args);
        UserService userService = run.getBean(UserService.class);
//        User newUser = new User();
//        newUser.setPassword("pass");
//        newUser.setLogin("log");
//        userService.save(newUser);

        List<User> all = userService.findAll();
        for (User user : all) {
            System.out.println(user);
        }

    }
}