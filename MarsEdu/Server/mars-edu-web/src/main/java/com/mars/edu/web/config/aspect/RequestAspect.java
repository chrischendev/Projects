package com.mars.edu.web.config.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * create by: Chris Chan
 * create on: 2019/6/14 6:42
 * use for:
 */
@Aspect
@Component
public class RequestAspect {
    //@Pointcut("execution(public * com.mars.edu.web.api..*(..))")
    @Pointcut("@within(org.springframework.web.bind.annotation.RequestMapping)")
    public void log() {
    }

    @Before("log()")
    public void before(JoinPoint joinPoint) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        System.out.println("AOP.URL==>" + request.getRequestURL());
        System.out.println("AOP.Params==>" + request.getQueryString());
        System.out.println("AOP.API==>" + joinPoint.getSignature().getName());
    }
}
