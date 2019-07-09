package com.mars.edu.app.library.manager;

import android.content.Context;

/**
 * @author Chris Chan
 * on 2019/7/9 10:15
 * use for: 工具类管理器
 */
public class UtilsManager {
    public static Context mContext;

    public static void init(Context context) {
        UtilsManager.mContext = context;
    }
}
