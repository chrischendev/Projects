package com.chris.base.library.base.mvp;

import java.util.List;

public interface BaseDataListView<T> extends BaseView {
    void loadData(List<T> dataList);

    void updateData(List<T> dataList);

    void loadMore(List<T> dataList);
}
