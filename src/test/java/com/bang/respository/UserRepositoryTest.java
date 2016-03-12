package com.bang.respository;

import com.bang.mapper.UserMapper;
import com.bang.model.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static junit.framework.TestCase.*;
import static org.mockito.Mockito.when;

public class UserRepositoryTest {

    @InjectMocks
    UserRepository userRepository;

    @Mock
    UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        userRepository.mapper = userMapper;
    }

    @Test
    public void shouldReturnUserWhenGiveUserNameIsBang() throws Exception {
        //Given
        String name = "bang";
        User user = new User();
        when(userMapper.getUserByName(name)).thenReturn(user);
        //When
        User isExited = userRepository.getUserByName(name);

        //Then
        assertNotNull(isExited);
    }

    @Test
    public void shouldReturnNullWhenGivenUserNameIsTest() throws Exception {
        //Given
        String name = "test";
        when(userMapper.getUserByName(name)).thenReturn(null);

        //When
        User isExited = userRepository.getUserByName(name);

        //Then
        assertNull(isExited);

    }

    @Test
    public void shouldReturnTrueWhenGiveUserIsNotExit() throws Exception {
        //Given
        User user = new User();
        when(userMapper.getUserByName(user.getName())).thenReturn(null);

        //When
        boolean isCreated = userRepository.createUser(user);

        //Then
        assertTrue(isCreated);
    }

    @Test
    public void shouldReturnFalseWhenGiveUserIsExit() throws Exception {
        //Given
        String name = "name";
        User user = new User();
        user.setName(name);

        User exitedUser = new User();
        exitedUser.setName(name);

        when(userMapper.getUserByName(name)).thenReturn(exitedUser);

        //When
        boolean isExiting = userRepository.createUser(user);

        //Then
        assertFalse(isExiting);
    }
}