package com.rainhard.jdbc.service;

import com.rainhard.jdbc.entity.UserRoles;
import com.rainhard.jdbc.repository.UserRolesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserRolesServiceTest {

    @InjectMocks
    private UserRolesService userRolesService;

    @Mock
    private UserRolesRepository usersRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void addUserRole() {
    }

    @Test
    void getAllUserRoles() {
        var userRoles = new UserRoles();
        when(usersRepository.findAllUsersRole()).thenReturn(List.of(userRoles));
        List<UserRoles> userRole = userRolesService.getAllUserRoles();
        assertNotNull(userRole);
    }
}