package com.mars.edu.web.config;

import com.google.gson.Gson;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * create by: Chris Chan
 * create on: 2019/6/9 16:06
 * use for:
 */
@Configuration
public class BeanBox {
    @Bean
    public Gson gson() {
        return new Gson();
    }
}
