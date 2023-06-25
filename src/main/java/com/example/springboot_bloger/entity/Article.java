package com.example.springboot_bloger.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Article {
    @TableId(value = "article_id",type = IdType.AUTO)
    private Integer articleId;  //文章ID
    private Integer articleUserId;  //文章对应的用户id
    private String articleTitle;    //文章标题
    private Integer articleViewCount;   //文章浏览量
    private Integer articleCommentCount;    //文章评论量
    private Integer articleLikeCount;
    private Date articleCreateTime;     //文章创建时间
    private Date articleUpdateTime;     //文章更新时间
    private Integer articleIsComment;
    private Integer articleStatus;
    private Integer articleOrder;
    private String articleContent;      //文章内容主体
    private String articleSummary;
    private String articleThumbnail;

    @TableField(select = false)
    private User user;
//    private List<Tag> tagList;
//    private List<Category> categoryList;
}
