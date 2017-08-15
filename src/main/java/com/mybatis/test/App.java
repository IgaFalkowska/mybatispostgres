package com.mybatis.test;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class App
{

    public List<User> getUsers() throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserMapper userMapper =session.getMapper(UserMapper.class);
        List<User> users= userMapper.getAllUsers();
        session.close();
        return users;
    }

    public User createUser(User user) throws Exception{
        SqlSession session = ConnectionFactory.getSession().openSession();
        UserMapper userMapper =session.getMapper(UserMapper.class);
        userMapper.insertUser(user);
        session.commit();
        session.close();
        return user;
    }

    public static void main(String a[])throws Exception{

        App app = new App();
        User user= new User();

        user.setFirstName("Grażyna");
        user.setLastName("Nowak");

        System.out.println(app.createUser(user));
        System.out.println(app.getUsers());

    }
}
