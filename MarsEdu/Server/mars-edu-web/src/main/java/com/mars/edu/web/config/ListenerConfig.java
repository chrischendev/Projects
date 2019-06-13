package com.mars.edu.web.config;

import com.mars.edu.web.config.listener.ContextListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * Created by Chris Chen
 * 2017/9/16
 * Explain:
 */
//@Configuration
public class ListenerConfig {
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean() {
        ServletListenerRegistrationBean slrBean = new ServletListenerRegistrationBean();
        slrBean.setListener(new ContextListener());
        return slrBean;
    }
}
