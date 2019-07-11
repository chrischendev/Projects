package com.chris.base.library.base.mvp;

public interface BasePresenter<View extends BaseView> {
    void bind(View view);

    void unbind();
}
