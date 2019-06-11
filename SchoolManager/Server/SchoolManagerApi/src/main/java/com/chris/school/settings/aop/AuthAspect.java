package com.chris.school.settings.aop;


import com.chris.framework.builder.net.protocol.NetRequest;
import com.chris.framework.builder.utils.MsgUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * YuedaoApi
 * com.meiyue.config.aspect
 * Created by Chris Chen
 * 2017/9/18
 * Explain:处理登录用户权限检查AOP
 */
//@Aspect
//@Component
//@Order(2)
public class AuthAspect {
    private static final String execution_01 = "execution(public * com.ydx.consumer.api..*(..)))";
    private static final String execution_02 = "@annotation(com.ydx.api.libs.annotation.AuthorityCheck)";
    private static final String execution_03 = execution_02 + " and " + execution_01;
//    @Autowired
//    CheckService checkService;

    @Pointcut(execution_01)
    public void check() {
    }

    @Before(value = "check()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        //检查是否具有登录用户接口调用权限
        Object[] args = joinPoint.getArgs();
        NetRequest netRequest = null;
        if (args.length == 1) {
            netRequest = (NetRequest) args[0];
            //获取token
            String token = netRequest.getProtocol().getToken();
            //检查权限
            //checkService.hasLoginAuthority(token);
            MsgUtils.debug("AOP.LoginUserToken==>" + token);
            //todo:修改实时经纬度也可以放在这里
        }
    }
}
