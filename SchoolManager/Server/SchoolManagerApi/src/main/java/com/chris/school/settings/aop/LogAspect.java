package com.chris.school.settings.aop;


import com.chris.framework.builder.net.protocol.NetRequest;
import com.chris.framework.builder.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * YuedaoApi
 * com.meiyue.config.aspect
 * Created by Chris Chen
 * 2017/9/18
 * Explain:打印请求日志的AOP
 */
@Aspect
@Component
@Order(1)
@Slf4j
public class LogAspect {
    private static final String execution_01 = "execution(public * com.chris.school.api..*(..)))";
    private static final String execution_02 = "@annotation(org.springframework.web.bind.annotation.PostMapping)";

    //    @Pointcut(execution_02 + " And " + execution_01)
    @Pointcut(execution_02)
    public void log() {
    }

    @Before(value = "log()")
    public void doBefore(JoinPoint joinPoint) {
        log.debug("收获了~~~~");
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        log.debug("AOP.URL==>" + request.getRequestURL());//打印请求路径


        String action = joinPoint.getSignature().getName();
        if (request.getQueryString() == null) {
            Object[] args = joinPoint.getArgs();
            NetRequest netRequest = null;
            if (args.length == 1) {
                Object arg = args[0];
                if (arg instanceof NetRequest) {
                    netRequest = (NetRequest) arg;
                    log.debug("AOP.RequestBody==>" + JsonUtils.toJson(netRequest));//打印body请求数据
                }
//                LogUtils.d("AOP.RequestBody==>这是个特殊接口");//打印body请求数据
            }
        } else {
            log.debug("AOP.Params==>" + request.getQueryString());//打印请求query字符串
        }
        log.debug("AOP.API==>" + action);//打印API函数名
    }
}
