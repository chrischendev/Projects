package com.chris.sl.manager;

import com.chris.sl.model.LoginInfo;
import com.chris.sl.model.LoginUser;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * create by: Chris Chan
 * create on: 2019/10/2 11:28
 * use for: 数据管理器
 * 因为目的只是为了走通逻辑，为方便移植，此处不用外部数据库，用内存数据模拟数据库
 * 如果改用mysql、redis，只需要改变方法的实现
 */
public class DataManager {
    //用户信息
    public static Map<String, LoginUser> userMap = new HashMap<>(16);
    //登录识别码池
    public static Map<String, LoginInfo> loginInfoMap = new HashMap<>(16);

    /**
     * 初始化
     */
    public static void init() {
        userMap.put("kaly", new LoginUser("kalychen", "123456"));
        userMap.put("chris", new LoginUser("chris", "123456"));
        userMap.put("will", new LoginUser("will", "123456"));
        userMap.put("chenfabao", new LoginUser("chenfabao", "123456"));
    }

    /**
     * 添加一个登录信息
     *
     * @param code
     */
    public static void addLoginInfo(String code) {
        //过期时间设置为5分钟
        long exp = LocalDateTime.now().plusMinutes(5).toInstant(ZoneOffset.of("+8")).toEpochMilli();
        loginInfoMap.put(code, new LoginInfo(null, exp, false));
    }

    /**
     * 占用登录信息
     *
     * @param code
     * @param username
     */
    public static void occLoginInfo(String code, String username) {
        LoginInfo loginInfo = loginInfoMap.get(code);
        if (null == loginInfo) {
            return;
        }
        loginInfo.setUsername(username);
        loginInfo.setOcc(true);
    }

    /**
     * 验证用户
     *
     * @param username
     * @param password
     * @param code
     * @return
     */
    public static boolean verification(String username, String password, String code) {
        LoginUser loginUser = userMap.get(username);
        //检查用户是否存在
        if (loginUser == null) {
            return false;
        }
        //检查密码是否正确
        if (!password.equalsIgnoreCase(loginUser.getPassword())) {
            return false;
        }
        //检查二维码识别码是否存在或过期
        LoginInfo loginInfo = loginInfoMap.get(code);
        long currentTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        if (null == loginInfo || loginInfo.getExpire() > currentTime) {
            return false;
        }
        return true;
    }

    /**
     * 检查占用
     *
     * @param code
     * @return
     */
    public static boolean checkOcc(String code) {
        LoginInfo loginInfo = loginInfoMap.get(code);
        if (null == loginInfo) {
            return false;
        }
        return loginInfo.isOcc();
    }

    /**
     * 获取登录用户名
     *
     * @param code
     * @return
     */
    public static LoginUser getUserByCode(String code) {
        LoginInfo loginInfo = loginInfoMap.get(code);
        if (null == loginInfo) {
            return null;
        }
        return userMap.get(loginInfo.getUsername());
    }

    /**
     * 整理登录信息
     * 主要是把已经过期的部分全部删除，否则数据会很大
     */
    public static void refreshLoginInfo() {
        //收集过期的code
        Set<String> codeSet = new HashSet<>(16);
        //收集
        long currentTime = LocalDateTime.now().toInstant(ZoneOffset.of("+8")).toEpochMilli();
        for (Map.Entry<String, LoginInfo> entry : loginInfoMap.entrySet()) {
            if (entry.getValue().getExpire() > currentTime) {
                codeSet.add(entry.getKey());
            }
        }
        //删除
        for (String code : codeSet) {
            loginInfoMap.remove(code);
        }
    }
}
