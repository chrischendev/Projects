package com.mars.edu.web.config.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * YuedaoApi
 * com.yuedao.config.interceptor
 * Created by Chris Chen
 * 2017/9/20
 * Explain:处理身份验证的拦截器
 */
public class AuthorityIntercepter extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String cell = request.getParameter("cell");
        String sessionId = request.getParameter("sessionId");

        if (cell == null || sessionId == null) {
            return true;
        }
        return super.preHandle(request, response, handler);
    }
}
