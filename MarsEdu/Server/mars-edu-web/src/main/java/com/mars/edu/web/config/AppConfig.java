package com.mars.edu.web.config;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Create by Chris Chan
 * Create on 2019/6/6 13:47
 * Use for:
 */

@EnableSwagger2
@Configuration
@EnableAspectJAutoProxy
@ServletComponentScan(basePackages = {"com.mars.edu.web"})
@EnableJpaRepositories(basePackages = {"com.mars.edu.web.dao"})
public class AppConfig {
}


