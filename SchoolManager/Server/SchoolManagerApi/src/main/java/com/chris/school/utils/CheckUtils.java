package com.chris.school.utils;

import org.springframework.stereotype.Service;

/**
 * YuedaoXingApi
 * com.ydx.api.biz.impl
 * Created by Chris Chen
 * 2017/11/16
 * Explain:各种检查
 */
@Service
public class CheckUtils {
//    @Autowired
//    SuperUserDao superUserDao;

    public boolean checkAppkey(String appkey) {
        String[] appKeys = {"app-key"};
        for (String key : appKeys) {
            if (key.equalsIgnoreCase(appkey)) {
                return true;
            }
        }
        throw new RuntimeException("appkey error");//appkey无效
    }

    public boolean hasAdminAuthority(String token) {
//        //1. 检查token是否为空
//        if (StringUtils.isEmpty(token) || "".equalsIgnoreCase(token)) {
//            //抛出异常，token已经失效(token为空)
//            throw new RuntimeException("token invalide");
//        }
//        //2. 根据token查找超级管理员
//        SuperUserEntity admin = superUserDao.findFirstByToken(token);//超级系统管理员
//        if (admin == null) {
//            //如果两个都没有，抛出异常，token已经失效
//            throw new RuntimeException("token invalide");
//        }
        return true;
    }

}
