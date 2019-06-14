package com.mars.edu.web.config.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * create by: Chris Chan
 * create on: 2019/6/14 6:23
 * use for:
 */
@WebFilter(urlPatterns = "/*")
@Order(1)
public class RequestFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("请求过滤器~~~");
        //System.out.println(((HttpServletRequest)servletRequest).getQueryString());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
