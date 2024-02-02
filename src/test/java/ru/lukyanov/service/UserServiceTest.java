package ru.lukyanov.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.lukyanov.entity.User;
import ru.lukyanov.repository.UserRepo;

import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@RequiredArgsConstructor
class UserServiceTest {
    @Mock
    private UserRepo userRepo;
    @InjectMocks
    private UserService userService;

    private User mockUser;

    @BeforeEach
    void setup() {
        mockUser = User.builder().id(1L).login("mockLogin").password("mockPassword").build();
    }

    @Test
    void findById() {
        Mockito.doAnswer(invocationOnMock -> Optional.of(mockUser)).when(userRepo).findById(1L);
        Optional<User> byId = userService.findById(1L);
        Assertions.assertTrue(byId.isPresent());
        Assertions.assertEquals("mockLogin", byId.get().getLogin());
        Mockito.verify(userRepo, Mockito.times(1)).findById(1L);
        Mockito.verifyNoMoreInteractions(userRepo);
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void findByLoginAndPassword() {
    }
}