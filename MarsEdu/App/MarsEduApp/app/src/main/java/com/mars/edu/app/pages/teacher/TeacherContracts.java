package com.mars.edu.app.pages.teacher;

import com.mars.edu.app.base.mvp.BasePresenter;
import com.mars.edu.app.base.mvp.BaseView;

public interface TeacherContracts {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
