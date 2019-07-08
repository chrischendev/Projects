package com.mars.edu.app.base.mvp;

public interface DefaultContracts {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
