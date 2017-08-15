package com.mybatis.test;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    String insert = "Insert into postgres.public.user(first_name, last_name) values (#{firstName}, #{lastName})";
    String getAll = "SELECT * FROM postgres.public.user";

    @Insert(insert)
    @Options(useGeneratedKeys = true)
    int insertUser(User user);

    @Select(getAll)
    @Results(value = {
            @Result(property = "id", column = "id"),
            @Result(property = "firstName", column = "first_name"),
            @Result(property = "lastName", column = "last_name"),
    })
    List<User> getAllUsers();

}
