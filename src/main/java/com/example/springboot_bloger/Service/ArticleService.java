package com.example.springboot_bloger.Service;

import com.example.springboot_bloger.entity.Article;

import java.util.List;

public interface ArticleService {
    // 前台查看所有文章信息
    List<Article> findAll();

    // 前台根据id查看信息
    Article getById(Integer id);
}
