package com.mars.edu.app.library.base.mvp;

public interface BaseRequestPresenter<View extends BaseView> extends BasePresenter<View> {
    void requestData();
}
