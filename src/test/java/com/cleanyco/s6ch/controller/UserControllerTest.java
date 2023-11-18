package com.cleanyco.s6ch.controller;

import com.cleanyco.s6ch.model.User;
import com.cleanyco.s6ch.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserController userController;

    private User user;

    @BeforeEach
    public void setUp() {
        user = new User();
        user.setUsername("testUser");
    }

    @Test
    public void testSignUpWhenUserDoesNotExistThenUserIsSaved() {
        // Arrange
        when(userRepository.existsById(user.getUsername())).thenReturn(false);

        // Act
        ResponseEntity<String> response = userController.signUp(user);

        // Assert
        verify(userRepository, times(1)).save(user);
        assertEquals("User was successfully created", response.getBody());
        assertEquals(200, response.getStatusCodeValue());
    }

    @Test
    public void testSignUpWhenUserExistsThenBadRequest() {
        // Arrange
        when(userRepository.existsById(user.getUsername())).thenReturn(true);

        // Act
        ResponseEntity<String> response = userController.signUp(user);

        // Assert
        verify(userRepository, times(0)).save(user);
        assertEquals("User already exists!d", response.getBody());
        assertEquals(400, response.getStatusCodeValue());
    }
}