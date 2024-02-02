package ru.lukyanov.integrations;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.lukyanov.entity.User;
import ru.lukyanov.service.UserService;

@SpringBootTest
class UserServiceIntegrationTest {

    @Autowired
    private UserService userService;

    @Test
    void findById() {
        User userFromDb = userService.findById(10L).orElseThrow();
        Assertions.assertEquals(10L, userFromDb.getId());
        Assertions.assertNotEquals(1L, userFromDb.getId());
        Assertions.assertEquals("Log4", userFromDb.getLogin());
        Assertions.assertEquals("Pass4", userFromDb.getPassword());

    }
}
