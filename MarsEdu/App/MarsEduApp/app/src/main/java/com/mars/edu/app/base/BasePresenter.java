package com.mars.edu.app.base;

public interface BasePresenter<View extends BaseView> {
    void bind(View view);

    void unbind();
}
