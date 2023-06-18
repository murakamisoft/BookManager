package com.bookmanager.book.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bookmanager.book.entity.User;

@Mapper
public interface UserMapper {

    @Select({
            "select * from user where user_name = #{userName} limit 1"
    })
    User selectByName(String userName);

    @Select({
            "select * from user where user_id = #{userId}"
    })
    User findUserId(Integer userId);

    @Insert({
        "insert into user(user_id, user_name, password, created_date, created_user, updated_date, updated_user) values(#{userId}, #{userName}, #{password}, now(), 'test', now(), 'test')"
    })
    void save(Integer userId, String userName, String password);

}
