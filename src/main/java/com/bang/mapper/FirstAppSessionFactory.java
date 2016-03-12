package com.bang.mapper;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;

public class FirstAppSessionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    static{
        if (sqlSessionFactory == null) {
            try {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("databaseConfig.xml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private FirstAppSessionFactory() {
    }


    public static SqlSessionFactory getInstance() {
        return sqlSessionFactory;
    }


}
