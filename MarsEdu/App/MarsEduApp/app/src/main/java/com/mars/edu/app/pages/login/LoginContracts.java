package com.mars.edu.app.pages.login;

import com.mars.edu.app.library.base.mvp.BaseDataView;
import com.mars.edu.app.library.base.mvp.BasePresenter;

/**
 * @author Chris Chan
 * on 2019/7/8 15:30
 * use for:
 */
public interface LoginContracts {
    interface View extends BaseDataView {
    }

    interface Presenter extends BasePresenter<View> {
        void requestData();
    }
}
