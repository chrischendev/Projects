package com.mars.edu.app.pages.home;

import com.mars.edu.app.library.base.mvp.BasePresenter;
import com.mars.edu.app.library.base.mvp.BaseView;

/**
 * @author Chris Chan
 * on 2019/7/9 10:37
 * use for:
 */
public interface HomeContracts {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
