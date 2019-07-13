package com.mars.edu.app.locallibs.common;

import com.chris.base.library.base.application.BaseApplication;
import com.chris.base.library.manager.UtilsManager;

/**
 * @author Chris Chan
 * on 2019/7/9 10:22
 * use for:
 */
public class MarsEduApplication extends BaseApplication {
    @Override
    protected void init() {
        UtilsManager.init(getApplicationContext());
    }
}
