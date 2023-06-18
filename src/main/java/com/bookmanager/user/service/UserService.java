package com.bookmanager.user.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;

import com.bookmanager.book.repository.UserMapper;

public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean existUserId(Integer userId) {
        return Objects.nonNull(userMapper.findUserId(userId));
    }

    public void add(Integer userId, String userName, String password, String passwordCheck) {
    }

}
