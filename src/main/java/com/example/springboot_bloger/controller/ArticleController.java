package com.example.springboot_bloger.controller;

import com.example.springboot_bloger.Service.ArticleService;
import com.example.springboot_bloger.controller.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*",maxAge = 3600)
@RestController
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * 前台显示文章
     * @return
     */
    @GetMapping
    public R findAll(){
        return new R(true,articleService.findAll());
    }

    /**
     * 前台根据id显示文章
     * @param id
     * @return
     */
    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true,articleService.getById(id));
    }
}