package com.chris.base.library.base.mvp;

public interface DefaultContracts {
    interface View extends BaseView {
    }

    interface Presenter extends BasePresenter<View> {
    }
}
