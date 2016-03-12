package com.bang.controller;

import com.bang.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @InjectMocks
    UserController userController;

    @Mock
    UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        userController.userService = userService;
    }

    @Test
    public void shouldReturnOkWhenValidateUser() throws Exception {
        //given
        User user = new User();
        when(userService.validateUser(user)).thenReturn(true);
        //when
        ResponseEntity response = userController.login(user);
        //then
        assertEquals(HttpStatus.OK,response.getStatusCode());
    }

    @Test
    public void shouldReturnNotFoundWhenValidateUserFail() throws Exception {
        //given
        User user = new User();
        when(userService.validateUser(user)).thenReturn(false);
        //when
        ResponseEntity response = userController.login(user);
        //then
        assertEquals(HttpStatus.NOT_FOUND,response.getStatusCode());
    }
}