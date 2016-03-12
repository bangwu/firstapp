package com.bang.service;

import com.bang.controller.User;
import com.bang.respository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public UserRepository userRepository;

    public boolean validateUser(User user) {
        User existUser = userRepository.getUserByName(user.getName());
        return existUser != null && existUser.getPassword().equals(user.getPassword());
    }
}
