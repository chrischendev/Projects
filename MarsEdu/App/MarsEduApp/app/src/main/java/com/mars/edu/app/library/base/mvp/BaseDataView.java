package com.mars.edu.app.library.base.mvp;

public interface BaseDataView<T> extends BaseView {
    void loadData(T data);

    void updateData(T data);
}
