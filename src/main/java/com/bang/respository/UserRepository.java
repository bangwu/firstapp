package com.bang.respository;

import com.bang.controller.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserRepository {

    private static List<User> users = new ArrayList<>();

    static {
        users.add(new User("name1", "password1"));
        users.add(new User("name2", "password2"));
        users.add(new User("name3", "password3"));
    }

    public User getUserByName(String name) {
        for(User user : users){
            if( user.getName().equals(name)){
                return user;
            }
        }
        return null;
    }
}
