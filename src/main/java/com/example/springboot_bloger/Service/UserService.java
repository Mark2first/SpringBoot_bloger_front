package com.example.springboot_bloger.Service;

import com.example.springboot_bloger.entity.User;

public interface UserService {
    // 登录查询
    User login(String username, String password);

    // 登陆查询
    User login2(User user);
}
