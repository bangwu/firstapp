package com.bang.respository;

import com.bang.controller.User;
import com.bang.mapper.FirstAppSessionFactory;
import com.bang.mapper.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;


@Repository
public class UserRepository {

    SqlSessionFactory sqlSessionFactory;

    private final SqlSession sqlSession;
    private final UserMapper mapper;

    public UserRepository() {
        this.sqlSessionFactory = FirstAppSessionFactory.getInstance();
        sqlSession = sqlSessionFactory.openSession();

        mapper = sqlSession.getMapper(UserMapper.class);
    }

    public User getUserByName(String name) {
        return mapper.getUserByName(name);
    }

    public boolean createUser(User user) {
        if (getUserByName(user.getName()) == null) {
            mapper.insert(user);
            sqlSession.commit();
            return true;
        }
        return false;
    }
}
