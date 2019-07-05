package com.mars.edu.app.base;

public interface DefaultContracts {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
