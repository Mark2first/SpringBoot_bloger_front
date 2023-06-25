package com.example.springboot_bloger.Service.impl;

import com.example.springboot_bloger.Dao.UserDao;
import com.example.springboot_bloger.Service.UserService;
import com.example.springboot_bloger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(String username, String password) {
        User user = userDao.login(username,password);
        return user;
    }

    @Override
    public User login2(User user) {
        User userBD = userDao.login2(user);
        if(userBD!=null){
            return (User) userDao;
        }
        throw new RuntimeException("登陆失败");
    }
}
