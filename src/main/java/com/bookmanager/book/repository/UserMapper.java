package com.bookmanager.book.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.bookmanager.book.entity.User;

@Mapper
public interface UserMapper {

    @Select({
        "select * from user where user_name = #{userName} limit 1"
    })
    User selectByName(String userName);
    
}
