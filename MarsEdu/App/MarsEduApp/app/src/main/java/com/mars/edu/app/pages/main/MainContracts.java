package com.mars.edu.app.pages.main;

import com.chris.base.library.base.mvp.BasePresenter;
import com.chris.base.library.base.mvp.BaseView;

/**
 * @author Chris Chan
 * on 2019/7/9 9:08
 * use for:
 */
public interface MainContracts {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
