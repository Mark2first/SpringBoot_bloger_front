package com.example.springboot_bloger;

import com.example.springboot_bloger.Dao.ArticleDao;
import com.example.springboot_bloger.Dao.UserDao;
import com.example.springboot_bloger.entity.Article;
import com.example.springboot_bloger.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class SpringBootBlogerApplicationTests {

    @Autowired
    private ArticleDao articleDao;

    @Autowired
    private UserDao userDao;

    @Test
    void testSave(){
//        System.out.println(articleDao.selectList(null));
//        System.out.println(articleDao.selectById(89));
//        String username = "wangwu";
//        String password = "12346";
//        System.out.println(userDao.login(username,password));
//        System.out.println(articleDao.AdminArticleList());
        // User查找id
//        System.out.println(userDao.selectById(1));
    }
//
//    @Test
//    void select(){
////        System.out.println(userDao.selectList(null));
//        System.out.println(userDao.selectById(17));
//    }
//
//    @Test
//    void testCreate(){
//        User user = new User();
//        user.setUserName("cz");
//        user.setUserPass("12345");
//        user.setUserNickname("Caozheng");
//        userDao.insert(user);
//    }
//
//    @Test
//    void testUpadte(){
//        User user = new User();
//        user.setUserId(17);
//        user.setUserName("cz1");
//        user.setUserPass("123333");
//        userDao.updateById(user);
//    }
//
//    @Test
//    void testDelete(){
//        userDao.deleteById(17);
//    }
//
//    @Test
//    void testAritcleInsert(){
//        Article article = new Article();
//        article.setArticleUserId(1);
//        article.setArticleTitle("测试1");
//        article.setArticleContent("测试1测试1测试1测试1测试1测试1");
//        article.setArticleCreateTime(new Date());
//        articleDao.AdminArticleInsert(article);
//    }
//
//    @Test
//    void testDeleteArticle(){
//        articleDao.deleteById(93);
//    }
//
//    @Test
//    void Testlogin2(){
//        User user = new User();
//        user.setUserName("admin");
//        user.setUserPass("123456");
//        System.out.println(userDao.login2(user));
//    }
//
//    @Test
//    void TestView3(){
//        System.out.println(articleDao.findArticleDetailByUserId(1));
//    }

}
