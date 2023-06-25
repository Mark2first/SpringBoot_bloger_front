package com.example.springboot_bloger.controller;

import com.example.springboot_bloger.Dao.ArticleDao;
import com.example.springboot_bloger.Service.AdminService;
import com.example.springboot_bloger.Service.ArticleService;
import com.example.springboot_bloger.controller.utils.R;
import com.example.springboot_bloger.entity.Article;
import com.example.springboot_bloger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
@RequestMapping("/admin/article")
public class AdminArticleController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ArticleService articleService;

    /**
     * Admin管理文章(Admin)查文章内容
     * @return
     */
    @GetMapping
    R findArticleList(){
        return new R(true,adminService.findArticleDetail());
    }

    /**
     * 根据用户信息查找id
     * @param session
     * @return
     */
    @GetMapping("/us")
    R findArticleListByUserId(HttpSession session){
        User user = (User) session.getAttribute("user");
        return new R(true,adminService.findArticleDetailByUserId(user.getUserId()));
    }

    /**
     * 根据文章id查找信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    R findArticleById(@PathVariable Integer id){
        return new R(true,articleService.getById(id));
    }

    /**
     * Admin编辑文章
     */
    @PutMapping
    R articleUpdate(@RequestBody Article article){
        Boolean flag = adminService.ArticleUpdate(article);
        return new R(flag , flag ? "修改成功":"修改失败");
    }

    /**
     * Admin添加文章
     * @param article
     * @return
     */
    @PostMapping
    R articleInsert(@RequestBody Article article,HttpSession session){
        // 通过Session获取user信息
        User user = (User) session.getAttribute("user");
        if(user!=null){
            article.setArticleUserId(user.getUserId());
        }
        Boolean flag = adminService.ArticleAdd(article);
        return new R(flag,flag ? "添加成功":"添加失败");
    }

    /**
     * Admin删除文章
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    R articleDelete(@PathVariable Integer id){
        return new R(adminService.ArticleDelete(id));
    }

}
