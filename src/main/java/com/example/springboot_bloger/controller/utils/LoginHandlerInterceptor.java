package com.example.springboot_bloger.controller.utils;

import com.example.springboot_bloger.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 登录成功后，取得用户session
        User loginUser = (User) request.getSession().getAttribute("user");
        //若无登陆
        if(loginUser==null){
            request.setAttribute("msg","无权限，请先登陆");
            request.getRequestDispatcher("/newLoginindex.html").forward(request,response);
            return false;
        }else{
            return true;
        }
    }
}
