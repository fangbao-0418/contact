package com.eiot6.Interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class HttpConfig implements WebMvcConfigurer {
    /**
     * 注册自定义拦截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // registry.addInterceptor(new InterceptorDemo2()).addPathPatterns("/**");
        System.out.println("intereptors");
        registry.addInterceptor(new HttpInterceptor()).addPathPatterns("/**");
    }
}
