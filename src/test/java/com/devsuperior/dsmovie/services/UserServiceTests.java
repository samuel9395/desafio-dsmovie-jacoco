package com.devsuperior.dsmovie.services;

import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.projections.UserDetailsProjection;
import com.devsuperior.dsmovie.repositories.UserRepository;
import com.devsuperior.dsmovie.tests.UserDetailsFactory;
import com.devsuperior.dsmovie.tests.UserFactory;
import com.devsuperior.dsmovie.utils.CustomUserUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
@ContextConfiguration
public class UserServiceTests {

    @InjectMocks
    private UserService service;

    @Mock
    private UserRepository repository;

    @Mock
    private CustomUserUtil userUtil;

    private String existingUserName, nonExistingUserName;
    private User user;
    private List<UserDetailsProjection> userDetails;

    @BeforeEach
    void setUp() throws Exception {
        existingUserName = "maria@gmail.com";
        nonExistingUserName = "joao@gmail.com";

        user = UserFactory.createUserEntity();
        userDetails = UserDetailsFactory.createCustomAdminUser(existingUserName);
    }

    @Test
    public void authenticatedShouldReturnUserEntityWhenUserExists() {

        Mockito.when(repository.findByUsername(existingUserName)).thenReturn(Optional.of(user));
        Mockito.when(userUtil.getLoggedUsername()).thenReturn(existingUserName);

        User result = service.authenticated();

        Assertions.assertNotNull(result);
        Assertions.assertEquals(existingUserName, result.getUsername());
    }

    @Test
    public void authenticatedShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists() {

        Mockito.when(repository.findByUsername(nonExistingUserName)).thenReturn(Optional.empty());
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.authenticated();
        });
    }

    @Test
    public void loadUserByUsernameShouldReturnUserDetailsWhenUserExists() {

        Mockito.when(repository.searchUserAndRolesByUsername(existingUserName)).thenReturn(userDetails);
        UserDetails result = service.loadUserByUsername(existingUserName);

        Assertions.assertNotNull(result);
        Assertions.assertEquals(existingUserName, result.getUsername());

    }

    @Test
    public void loadUserByUsernameShouldThrowUsernameNotFoundExceptionWhenUserDoesNotExists() {

        Mockito.when(repository.searchUserAndRolesByUsername(nonExistingUserName)).thenReturn(new ArrayList<>());
        Assertions.assertThrows(UsernameNotFoundException.class, () -> {
            service.loadUserByUsername(nonExistingUserName);
        });
    }
}
