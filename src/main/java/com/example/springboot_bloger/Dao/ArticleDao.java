package com.example.springboot_bloger.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_bloger.entity.Article;
import com.example.springboot_bloger.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Mapper
public interface ArticleDao extends BaseMapper<Article> {

    /**
     * Admin界面查询文章信息，包含User信息
     * @return
     */
    @Select("select * from article")
    @Result(property = "user",column = "article_user_id",javaType = User.class,
            one = @One(select = "com.example.springboot_bloger.Dao.UserDao.selectByName"))
    List<Article> AdminArticleList();

    @Select("select *from article where article_user_id = #{articleUserId}")
    List<Article> findArticleDetailByUserId(@Param("articleUserId") Integer articleUserId);

    @Insert("insert into article (article_user_id, article_title, article_content, article_create_time) " +
            "values (#{articleUserId}, #{articleTitle},#{articleContent},#{articleCreateTime})")
    @Results({
            @Result(property = "articleUserId",column = "article_user_id"),
            @Result(property = "articleTitle",column = "article_title"),
            @Result(property = "articleContent",column = "article_content"),
            @Result(property = "articleCreateTime",column = "article_create_time"),
            @Result(property = "user",column = "article_user_id",javaType = User.class)
    })
    Boolean AdminArticleInsert(Article article);
}
