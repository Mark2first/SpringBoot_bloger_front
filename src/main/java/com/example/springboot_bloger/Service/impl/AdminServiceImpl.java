package com.example.springboot_bloger.Service.impl;

import com.example.springboot_bloger.Dao.ArticleDao;
import com.example.springboot_bloger.Dao.UserDao;
import com.example.springboot_bloger.Service.AdminService;
import com.example.springboot_bloger.entity.Article;
import com.example.springboot_bloger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private UserDao userDao;

    @Override
    public List<Article> findArticleDetail() {
        List<Article> articles = articleDao.AdminArticleList();
        return articles;
    }

    @Override
    public List<Article> findArticleDetailByUserId(Integer id) {
        List<Article> articles = articleDao.findArticleDetailByUserId(id);
        return articles;
    }


    @Override
    public List<User> userList() {
        return userDao.selectList(null);
    }

    @Override
    public User userDetail(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public Boolean userAdd(User user) {
        return userDao.insert(user)>0;
    }

    @Override
    public Boolean userUpdate(User user) {
        return userDao.updateById(user)>0;
    }

    @Override
    public Boolean userDelete(Integer id) {
        return userDao.deleteById(id)>0;
    }

    @Override
    public Boolean ArticleAdd(Article article) {
        article.setArticleCreateTime(new Date());
        return articleDao.AdminArticleInsert(article);
    }

    @Override
    public Boolean ArticleUpdate(Article article) {
        return articleDao.updateById(article)>0;
    }

    @Override
    public Boolean ArticleDelete(Integer id) {
        return articleDao.deleteById(id)>0;
    }
}
