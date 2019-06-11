package com.chris.school.settings;

import com.chris.school.settings.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MeiyueJavaProject
 * com.meiyue.config
 * Created by Chris Chen
 * 2017/9/16
 * Explain:过滤器配置
 */
@Configuration
public class FilterConfig {
    @Bean
    public FilterRegistrationBean filterRegist() {
        FilterRegistrationBean frBean = new FilterRegistrationBean();
        frBean.setFilter(new LogFilter());
        frBean.addUrlPatterns("/*");
        return frBean;
    }
}
