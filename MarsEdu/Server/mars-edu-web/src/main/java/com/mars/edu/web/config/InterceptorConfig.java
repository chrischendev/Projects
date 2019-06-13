package com.mars.edu.web.config;

import com.mars.edu.web.config.interceptor.AuthorityIntercepter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * MeiyueJavaProject
 * com.meiyue.config
 * Created by Chris Chen
 * 2017/9/16
 * Explain:增加拦截器
 */
@Configuration
@EnableWebMvc//解决在拦截器中自动装载service不成功的问题
public class InterceptorConfig extends WebMvcConfigurerAdapter {
    @Bean
    AuthorityIntercepter authorityIntercepter() {
        return new AuthorityIntercepter();
    }

    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(new AuthorityIntercepter()).addPathPatterns("/**");
        super.addInterceptors(registry);
    }

}
