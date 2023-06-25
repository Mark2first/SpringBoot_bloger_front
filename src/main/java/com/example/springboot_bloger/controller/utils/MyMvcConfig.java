package com.example.springboot_bloger.controller.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 自定义视图解析器
 */
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.html").setViewName("login");
        registry.addViewController("/AdminArticle.html").setViewName("AdminArticle");
        registry.addViewController("/dashboard.html").setViewName("dashboard");
        registry.addViewController("/AdminUser.html").setViewName("AdminUser");
        registry.addViewController("/AdminArticleInsert.html").setViewName("AdminArticleInsert");
        registry.addViewController("/AdminArticleUser.html").setViewName("AdminArticleUser");
        registry.addViewController("/newLoginindex.html").setViewName("newLoginindex");
    }

    /**
     * 拦截器
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/newLoginindex.html","/login","/","/article","/article/*",
                        "/css/**","/js/**","/plugins/**","/images/**");
    }
}
