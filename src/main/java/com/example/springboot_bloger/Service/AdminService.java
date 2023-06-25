package com.example.springboot_bloger.Service;

import com.example.springboot_bloger.entity.Article;
import com.example.springboot_bloger.entity.User;

import java.util.List;

public interface AdminService {
    // Admin界面显示所有文章（admin权限）
    List<Article> findArticleDetail();

    // Admin界面显示所有文章（user权限）
    List<Article> findArticleDetailByUserId(Integer id);

    // Admin界面显示所有用户信息
    List<User> userList();

    // Admin界面显示单个用户信息
    User userDetail(Integer id);

    // Admin界面添加个人信息
    Boolean userAdd(User user);

    // Admin界面编辑个人信息
    Boolean userUpdate(User user);

    // Admin界面删除个人信息
    Boolean userDelete(Integer id);

    // Admin界面新增文章
    Boolean ArticleAdd(Article article);

    // Admin界面编辑文章
    Boolean ArticleUpdate(Article article);

    // Admin界面删除文章
    Boolean ArticleDelete(Integer id);
}
