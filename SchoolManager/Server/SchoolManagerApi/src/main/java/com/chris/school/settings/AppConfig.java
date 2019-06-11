package com.chris.school.settings;

import com.chris.framework.builder.libs.springboot.repository.BaseRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * SchoolManagerApi
 * com.chris.school.settings
 * Created by Chris Chen
 * 2018/7/3
 * Explain:
 */
@EnableWebMvc
@EnableAspectJAutoProxy
@Configuration
@ComponentScan(basePackages = {
        "com.chris.school"}
)
@EntityScan(basePackages = {
        "com.chris.school.model",
        "com.chris.framework.builder.model"
})
@EnableJpaRepositories(basePackages = {
        "com.chris.school.dao",
        "com.chris.framework.builder.libs"
},
        repositoryFactoryBeanClass = BaseRepositoryFactoryBean.class
)
public class AppConfig {
}
