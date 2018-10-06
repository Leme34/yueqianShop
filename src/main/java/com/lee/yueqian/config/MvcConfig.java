package com.lee.yueqian.config;

import com.lee.yueqian.interceptor.MyHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter{

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        return new WebMvcConfigurerAdapter() {
//            @Override
//            public void addInterceptors(InterceptorRegistry registry) {
//                registry.addInterceptor(new MyHandlerInterceptor())
//                        .addPathPatterns("/admin/editGoods","/admin/delGoods","/admin/allGoods","/admin/main","/admin/charts","/admin/tables","/admin/shop_manage");
//            }
        };
    }

}
