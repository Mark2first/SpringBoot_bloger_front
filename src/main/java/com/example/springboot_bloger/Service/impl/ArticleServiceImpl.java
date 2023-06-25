package com.example.springboot_bloger.Service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.springboot_bloger.Dao.ArticleDao;
import com.example.springboot_bloger.Service.ArticleService;
import com.example.springboot_bloger.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleDao articleDao;
    @Override
    public List<Article> findAll() {
        return articleDao.selectList(null);
    }

    @Override
    public Article getById(Integer id) {
        return articleDao.selectById(id);
    }
}
