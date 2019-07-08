package com.mars.edu.app.base.mvp;

public interface BasePresenter<View extends BaseView> {
    void bind(View view);

    void unbind();
}
