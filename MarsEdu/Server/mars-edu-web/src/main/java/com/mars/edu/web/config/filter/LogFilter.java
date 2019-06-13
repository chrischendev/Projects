package com.mars.edu.web.config.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * create by: Chris Chan
 * create on: 2019/6/14 6:23
 * use for:
 */
@WebFilter(urlPatterns = "/*")
@Order(2)
public class LogFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("日志过滤器~~~");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
