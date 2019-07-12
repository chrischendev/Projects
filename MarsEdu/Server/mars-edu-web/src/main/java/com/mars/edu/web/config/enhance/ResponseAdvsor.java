package com.mars.edu.web.config.enhance;

import com.chris.framework.builder.utils.ResultUtils;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.lang.reflect.Method;

/**
 * @author chrischan
 * create on 2019/7/10 14:27
 * use for: 接口增强处理
 * 把每一种返回结果都包裹在同一个数据结构NetResult中
 */
@ControllerAdvice
public class ResponseAdvsor implements ResponseBodyAdvice<Object> {

    /**
     * 注意判断条件的优先顺序
     * 如果大多数需要处理，或者大多数不需要处理，则应设计一个适应于更少需求的注解来判断
     *
     * @param methodParameter
     * @param aClass
     * @return
     */
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        Method method = methodParameter.getMethod();
        //1. 包含IncludeHeader注解不处理
        if (null != method.getDeclaredAnnotation(IncludeHeader.class)) {
            return false;
        }
        //2. 只对GetMapping和PostMapping接口做此处理
        if (null != method.getDeclaredAnnotation(GetMapping.class) ||
                null != method.getDeclaredAnnotation(PostMapping.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return ResultUtils.buildResult(body);
    }
}
