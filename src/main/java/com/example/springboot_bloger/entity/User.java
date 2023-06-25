package com.example.springboot_bloger.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class User {
    private static final long serialVersionUID = -4415517704211731385L;
    @TableId(value = "user_id",type = IdType.AUTO)
    private Integer userId;
    private String userName;
    private String userPass;
    private String userNickname;
    private String userEmail;
    private String userUrl;
    private String userAvatar;
    private String userLastLoginIp;
    private Date userRegisterTime;
    private Date userLastLoginTime;
    private Integer userStatus;

    /**
     * 用户角色：admin/user
     */
    private String userRole;

//    /**
//     * 文章数量（不是数据库字段）
//     */
//    private Integer articleCount;
}
