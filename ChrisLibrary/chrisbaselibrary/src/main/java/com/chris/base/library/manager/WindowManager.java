package com.chris.base.library.manager;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;

import java.util.Stack;

/**
 * @author Chris Chan
 * on 2019/7/9 10:18
 * use for: 窗口管理器
 */
public class WindowManager extends UtilsManager {
    private static Stack<Activity> activities;
    private static WindowManager instance;

    /**
     * 单例模式
     *
     * @return
     */
    public static WindowManager get() {
        if (instance == null) {
            instance = new WindowManager();
        }
        return instance;
    }

    /**
     * 添加一个Activity
     *
     * @param activity
     */
    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new Stack<>();
        }
        activities.add(activity);
    }

    /**
     * 移除一个Activity
     *
     * @param activity
     */
    public void removeActivity(Activity activity) {
        if (activities != null) {
            activities.remove(activity);
        }
    }

    /**
     * 按照类名移除Activity
     *
     * @param clazz
     */
    public void finishActivity(Class<?> clazz) {
        for (Activity activity : activities) {
            if (activity.getClass().equals(clazz)) {
                activities.remove(activity);
            }
        }
    }

    /**
     * 移除所有的Activity
     */
    public void finishAllActivities() {
        for (Activity activity : activities) {
            if (activity != null) {
                activity.finish();
            }
        }
        activities.clear();
    }

    /**
     * 退出应用程序
     *
     * @param context
     */
    public void exitApp(Context context) {
        try {
            finishAllActivities();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            activityManager.killBackgroundProcesses(context.getPackageName());
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 判断应用是否已经退出
     *
     * @return
     */
    public boolean isExit() {
        return activities == null || activities.isEmpty();
    }
}
