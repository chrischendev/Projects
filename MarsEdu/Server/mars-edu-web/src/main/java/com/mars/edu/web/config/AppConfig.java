package com.mars.edu.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:47
 * Use for:
 */
@Configuration
@EnableJpaRepositories(basePackages = {"com.mars.edu.web.dao"})
public class AppConfig {
}
