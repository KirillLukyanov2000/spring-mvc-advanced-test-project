package ru.lukyanov.integrations;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.jdbc.Sql;
import ru.lukyanov.entity.User;
import ru.lukyanov.service.UserService;

import java.util.List;
@TestContext
@RequiredArgsConstructor
class UserServiceIntegrationDetailedTest {

    private final UserService userService;

    @Test
    void findById() {
        User userFromDb = userService.findById(10L).orElseThrow();
        Assertions.assertEquals(10L, userFromDb.getId());

    }

    @Test
    void save() {
        User savedUser = userService.save(User
                .builder().login("999_login").password("999_password")
                .build());
        Assertions.assertEquals("999_login", savedUser.getLogin());
    }

    @Test
    void findAll() {
        List<User> all = userService.findAll();
        Assertions.assertEquals(8, all.size());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
        userService.deleteById(2L);
        List<User> all = userService.findAll();
        Assertions.assertEquals(7, all.size());
    }

    @Test
    @Sql(statements = "delete from users where id=11")
    void deleteById() {
        //userService.deleteById(9L);
        List<User> all = userService.findAll();
        Assertions.assertEquals(7, all.size());
    }
}
