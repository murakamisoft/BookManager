package com.bookmanager.user.service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bookmanager.book.repository.UserMapper;

@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public boolean existUserId(Integer userId) {
        return Objects.nonNull(userMapper.findUserId(userId));
    }

    public void add(Integer userId, String userName, String password, String passwordCheck) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePassword = passwordEncoder.encode(password);
        userMapper.save(userId, userName, encodePassword);
    }

}
