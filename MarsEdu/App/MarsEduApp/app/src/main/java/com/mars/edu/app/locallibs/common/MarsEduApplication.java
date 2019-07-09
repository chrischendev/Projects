package com.mars.edu.app.locallibs.common;

import com.mars.edu.app.library.base.application.BaseApplication;
import com.mars.edu.app.library.manager.UtilsManager;

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
