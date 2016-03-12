package com.bang.mapper;


import com.bang.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    @Select("Select * from Users where name = #{name}")
    User getUserByName(String name);

    @Insert("insert into users(name,password) values(#{name},#{password})")
    int insert(User user);
}
