package com.mars.edu.app.pages.scan;

import com.mars.edu.app.library.base.mvp.BasePresenter;
import com.mars.edu.app.library.base.mvp.BaseView;

/**
 * @author Chris Chan
 * on 2019/7/10 17:03
 * use for:
 */
public interface ScanContracts {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
