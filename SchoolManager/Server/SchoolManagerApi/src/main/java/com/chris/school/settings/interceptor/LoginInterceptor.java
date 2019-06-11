package com.chris.school.settings.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Service
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        StringBuffer requestURL = request.getRequestURL();
        String s = requestURL.toString();
        System.out.println(s);
        boolean b = s.endsWith("/") || s.endsWith("/error");
        if (b) {
            response.sendRedirect("/index.html");
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndView) throws Exception {
        if (request.getRequestURL().toString().endsWith("/getList")) {
//            ServletOutputStream outputStream = response.getOutputStream();
////            PrintWriter out = response.getWriter();
////            out.print("{'name':'老天爷啊'}");
////            System.out.println("处理过了");
////            out.close();
//            response.addHeader("token","1234321");
        }
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {

    }
}
