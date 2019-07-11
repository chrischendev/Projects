package com.mars.edu.app.pages.home;

import com.chris.base.library.base.mvp.BasePresenter;
import com.chris.base.library.base.mvp.BaseView;

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
