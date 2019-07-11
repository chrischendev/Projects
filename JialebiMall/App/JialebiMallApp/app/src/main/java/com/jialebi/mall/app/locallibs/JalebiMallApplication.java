package com.jialebi.mall.app.locallibs;

import com.chris.base.library.base.application.BaseApplication;
import com.chris.base.library.manager.UtilsManager;

/**
 * @author Chris Chan
 * on 2019/7/11 9:38
 * use for:
 */
public class JalebiMallApplication extends BaseApplication {
    @Override
    protected void init() {
        UtilsManager.init(getApplicationContext());
    }
}
