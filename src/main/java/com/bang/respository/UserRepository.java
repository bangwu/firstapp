package com.bang.respository;

import com.bang.mapper.FirstAppSessionFactory;
import com.bang.mapper.UserMapper;
import com.bang.model.User;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    public UserMapper mapper;

    public UserRepository() {
        mapper = FirstAppSessionFactory.getMapper(UserMapper.class);
    }



    public User getUserByName(String name) {
        return mapper.getUserByName(name);
    }

    public boolean createUser(User user) {
        if (getUserByName(user.getName()) == null) {
            mapper.insert(user);
            return true;
        }
        return false;
    }
}
