package com.mars.edu.chat;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chris.base.library.base.application.BaseApplication;
import com.chris.base.library.manager.UtilsManager;

/**
 * create by Chris Chan
 * create on 2019/7/14 0:15
 * use for :
 */
public class ChatApplication extends BaseApplication {
    @Override
    protected void init() {
        UtilsManager.init(getApplicationContext());
        ARouter.openLog();
        //ARouter.openDebug();
        ARouter.init(this);
    }
}
