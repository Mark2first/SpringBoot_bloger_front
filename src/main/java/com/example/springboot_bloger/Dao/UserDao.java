package com.example.springboot_bloger.Dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springboot_bloger.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao extends BaseMapper<User> {

    /**
     * 登陆查询
     * @param username
     * @param password
     * @return
     */
    @Select("select *from user where user_name=#{username} and user_pass=#{password}")
    User login(@Param("username")String username, @Param("password")String password);

    @Select("select *from user where user_id = #{id}")
    User selectByName(@Param("id")Integer id);

    @Results({
            @Result(property = "userName",column = "user_name"),
            @Result(property = "userPass",column = "user_pass"),
    })
    @Select("select *from user where user_name=#{username} and user_pass=#{userpass}")
    User login2(User user);

}
