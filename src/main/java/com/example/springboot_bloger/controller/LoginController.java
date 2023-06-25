package com.example.springboot_bloger.controller;

import com.example.springboot_bloger.Service.UserService;
import com.example.springboot_bloger.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@Controller   //用于thymeleaf登陆
//@RestController   //用于jwt登陆
@Slf4j
public class LoginController {

    @Autowired
    private UserService userService;

    /**
     * 利用thymeleaf实现登陆：用于单体架构
     * @param username
     * @param password
     * @param model
     * @return
     */
    @RequestMapping("/login")
    String login(@RequestParam("username")String username, @RequestParam("password")String password,
                 Model model, HttpSession session){
        User user = userService.login(username,password);
        if(user!=null){
            session.setAttribute("user",user);
            return "dashboard";
        }
        model.addAttribute("msg","用户名或密码错误");
        return "newLoginindex";
    }

    /**
     * 退出登陆
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/logout")
    String logout(HttpSession session,Model model){
        session.removeAttribute("user");
        model.addAttribute("msg","退出成功！");
        session.invalidate();
        return "newLoginindex";
    }

    /**
     * 利用jwt实现登陆：用于前后端分离架构
     * @return
     */
//    @GetMapping("/loginForJWT")
//    public Map<String,Object> login(@RequestParam("username") String username, @RequestParam("password") String password){
//        log.info("用户名:[[]]",username);
//        log.info("密码:[[]]",password);
//        Map<String,Object> map = new HashMap<>();
//        try{
//            User userDB = userService.login(username,password);
//            Map<String, String> payload = new HashMap<>();
//            payload.put("id",userDB.getUserId().toString());
//            payload.put("name", userDB.getUserName());
//            // 生成JWT的令牌
//            String token = jwtUtils.getToken(payload);
//            map.put("flag",true);
//            map.put("msg","认证成功");
//            map.put("token",token);
//        }catch (Exception e){p
//            map.put("flag",false);
//            map.put("msg",e.getMessage());
//        }
//        return map;
//    }
//
//    // token测试
//    @PostMapping("/user/test")
//    Map<String,Object> test(HttpServletRequest request){
//        Map<String,Object> map = new HashMap<>();
//        //处理自己业务逻辑
//        String token = request.getHeader("token");
//        DecodedJWT verify = jwtUtils.verify(token);
//        log.info("用户id[{}]",verify.getClaim("id").asString());
//        log.info("用户名[{}]",verify.getClaim("name").asString());
//        map.put("flag",true);
//        map.put("msg","请求成功");
//        return map;
//    }

}
