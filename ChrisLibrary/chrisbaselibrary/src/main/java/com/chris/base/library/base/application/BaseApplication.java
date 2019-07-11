package com.chris.base.library.base.application;

import android.app.Application;

/**
 * @author Chris Chan
 * on 2019/7/9 10:16
 * use for:
 */
public abstract class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    protected abstract void init();
}
