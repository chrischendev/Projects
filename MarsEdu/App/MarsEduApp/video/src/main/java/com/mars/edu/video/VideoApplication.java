package com.mars.edu.video;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chris.base.library.base.application.BaseApplication;
import com.chris.base.library.manager.UtilsManager;

/**
 * create by Chris Chan
 * create on 2019/7/14 10:46
 * use for :
 */
public class VideoApplication extends BaseApplication {
    @Override
    protected void init() {
        UtilsManager.init(getApplicationContext());
        ARouter.openLog();
        ARouter.init(this);
    }
}
