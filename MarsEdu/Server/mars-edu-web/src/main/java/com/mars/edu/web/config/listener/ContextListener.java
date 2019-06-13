package com.mars.edu.web.config.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * MeiyueJavaProject
 * com.meiyue.config.listener
 * Created by Chris Chen
 * 2017/9/16
 * Explain:
 */
//@WebListener
public class ContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("自定义监听器:ServletContextListener->contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
