package com.mars.edu.app.pages.login;

import com.chris.base.library.base.mvp.BaseDataView;
import com.chris.base.library.base.mvp.BasePresenter;
import com.mars.edu.app.model.User;

/**
 * @author Chris Chan
 * on 2019/7/8 15:30
 * use for:
 */
public interface LoginContracts {
    interface View extends BaseDataView<User> {
    }

    interface Presenter extends BasePresenter<View> {
        void requestData();
    }
}
