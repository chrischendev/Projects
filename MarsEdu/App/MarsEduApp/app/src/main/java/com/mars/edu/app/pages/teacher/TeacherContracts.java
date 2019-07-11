package com.mars.edu.app.pages.teacher;

import com.chris.base.library.base.mvp.BaseDataListView;
import com.chris.base.library.base.mvp.BaseRequestPresenter;
import com.mars.edu.app.model.TeacherModel;

public interface TeacherContracts {
    interface View extends BaseDataListView<TeacherModel> {
    }

    interface Presenter extends BaseRequestPresenter<View> {
    }
}
