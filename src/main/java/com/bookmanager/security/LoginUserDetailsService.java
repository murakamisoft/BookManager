package com.bookmanager.security;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bookmanager.book.entity.User;
import com.bookmanager.book.repository.UserMapper;

/***
 * ログインイン時に認証ユーザーをテーブルから情報を取得するクラス
 */
@Service
public class LoginUserDetailsService implements UserDetailsService {

    @Autowired
    UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        User user = userMapper.selectByName(name);

        // 該当レコードが取得できなかった場合はエラーにする
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("Wrong email or password");
        }

        return new LoginUserDetails(user);
    }
}