package com.example.springboot_bloger.controller;

import com.example.springboot_bloger.Service.AdminService;
import com.example.springboot_bloger.controller.utils.R;
import com.example.springboot_bloger.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/user")
public class UserController {

    @Autowired
    private AdminService adminService;

    /**
     * Admin管理用户
     * @return
     */
    @GetMapping
    R UserList(){
        return new R(true,adminService.userList());
    }

    /**
     * Admin查看用户个人信息
     * @param id
     * @return
     */
    @GetMapping("{id}")
    R UserDetail(@PathVariable Integer id){
        return new R(true,adminService.userDetail(id));
    }

    /**
     * 用户添加
     * @param user
     * @return
     */
    @PostMapping
    R UserAdd(@RequestBody User user){
        Boolean flag = adminService.userAdd(user);
        return new R(flag,flag ? "添加成功":"添加失败");
    }

    /**
     * 用户信息修改
     * @param user
     * @return
     */
    @PutMapping
    R UserUpdate(@RequestBody User user){
        Boolean flag = adminService.userUpdate(user);
        return new R(flag,flag ? "修改成功":"修改失败");
    }

    /**
     * 用户信息删除
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    R UserDelete(@PathVariable Integer id){
        return new R(adminService.userDelete(id));
    }
}