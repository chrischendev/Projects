package com.chris.base.library.base.mvp;

public interface BaseRequestPresenter<View extends BaseView> extends BasePresenter<View> {
    void requestData();
}
