package com.mars.edu.app.pages.news;

import com.mars.edu.app.library.base.mvp.BaseDataListView;
import com.mars.edu.app.library.base.mvp.BaseRequestPresenter;
import com.mars.edu.app.locallibs.net.NewsItem;

/**
 * create by Chris Chan
 * create on 2019/7/10 0:07
 * use for :
 */
public interface NewsContracts {
    interface View extends BaseDataListView<NewsItem> {

    }

    interface Presenter extends BaseRequestPresenter<View> {
        void getNewsList(String type);
    }
}
