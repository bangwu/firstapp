package com.bang.service;

import com.bang.model.User;
import com.bang.respository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    @InjectMocks
    UserService userService;

    @Mock
    UserRepository userRepository;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userService.userRepository  = userRepository;
    }

    @Test
    public void shouldReturnFalseWhenUserNotFound() throws Exception {
        //given
        User user = new User();
        String name = "name";
        user.setName(name);
        when(userRepository.getUserByName(name)).thenReturn(null);

        //when
        boolean isUserValid = userService.validateUser(user);

        //then
        assertFalse(isUserValid);
    }

    @Test
    public void shouldReturnTrueWhenUserValidate() throws Exception {
        //given
        User user = new User();
        String name = "name";
        user.setName(name);
        user.setPassword("password");

        User existingUser = new User();
        existingUser.setPassword("password");
        when(userRepository.getUserByName(name)).thenReturn(existingUser);

        //when
        boolean isUserValid = userService.validateUser(user);

        //then
        assertTrue(isUserValid);
    }

    @Test
    public void shouldReturnFalseWhenUserValidateFail() throws Exception {
        //given
        User user = new User();
        String name = "name";
        user.setName(name);
        user.setPassword("password1");

        User existingUser = new User();
        existingUser.setPassword("password2");
        when(userRepository.getUserByName(name)).thenReturn(existingUser);

        //when
        boolean isUserValid = userService.validateUser(user);

        //then
        assertFalse(isUserValid);
    }
}