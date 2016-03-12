package com.bang.service;

import com.bang.model.User;
import com.bang.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    public UserRepository userRepository;


    public boolean validateUser(User user) {
        User existUser = userRepository.getUserByName(user.getName());
        return existUser != null && existUser.getPassword().equals(user.getPassword());
    }

    public boolean createUser(User user) {
        return userRepository.createUser(user);
    }
}
