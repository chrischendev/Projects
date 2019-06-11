package com.chris.school.settings.interceptor;


import com.chris.framework.builder.utils.JsonUtils;
import com.chris.framework.builder.utils.MsgUtils;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class ResultInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("结果拦截器");
        Object proceed = methodInvocation.proceed();
        MsgUtils.debug(JsonUtils.toJson(proceed));
        return null;
    }
}
