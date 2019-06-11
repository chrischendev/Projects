package com.chris.school.settings.filter;

import com.chris.framework.builder.utils.MsgUtils;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * YuedaoXingApi
 * com.ydx.api.config.filter
 * Created by Chris Chen
 * 2017/11/11
 * Explain:打印请求日志的过滤器
 */
@Slf4j
public class LogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        StringBuffer requestURL = request.getRequestURL();
        MsgUtils.debug("URL: " + requestURL);

        String urlStr = requestURL.toString();
        String url = urlStr.substring(urlStr.lastIndexOf("/") );
        if ("/".equals(url)){
            response.sendRedirect("/index.html");
            return;
        }


        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
