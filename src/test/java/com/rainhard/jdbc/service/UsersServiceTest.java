package com.rainhard.jdbc.service;

import com.rainhard.jdbc.entity.Users;
import com.rainhard.jdbc.repository.UsersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UsersServiceTest {

    @InjectMocks
    private UsersService usersService;

    @Mock
    private UsersRepository usersRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void registration() {
        var user = new Users();
        user.setEmail("email");
        user.setPassword("123");

        when(usersRepository.save(user)).thenReturn(user);

        var savedUser = usersService.registration(user);

        assertNotNull(savedUser);
    }

    @Test
    void findAllUsers() {
        when(usersRepository.findAllUsers()).thenReturn(List.of());
        assertNotNull( usersService.findAllUsers());
    }

    @Test
    void checkUserEmail() {

        var user = new Users();
        user.setEmail("email");
        when(usersRepository.findByEmail("email")).thenReturn(Optional.of(user));

       var isEmailFound =  usersService.checkUserEmail("email");

       assertNotNull(isEmailFound);
       assertEquals(user.getEmail(), "email");
    }

    @Test
    void testAtomicLong(){
        final AtomicLong atomicLong = new AtomicLong();
        System.out.println(atomicLong.incrementAndGet());
        System.out.println(atomicLong.incrementAndGet());
        assertEquals(3L, atomicLong.incrementAndGet());
    }

    @Test
    void updateUser() {
        var users = new Users();
        users.setId(1L);
        users.setEmail("email");
        users.setUsername("username");

        when(usersRepository.updateUser(1L, "Rainhard")).thenReturn(1); //Row affected is 1 with specific ID

        int updatedUser = usersService.updateUser(1L, "Rainhard");

        assertNotEquals(10, updatedUser); // it is true because affected row is 1 with specific ID, not 10
        assertEquals(1, updatedUser);
    }
}