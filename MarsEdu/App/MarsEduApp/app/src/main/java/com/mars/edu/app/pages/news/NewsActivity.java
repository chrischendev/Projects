package com.mars.edu.app.pages.news;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.mars.edu.app.R;
import com.mars.edu.app.library.base.activity.BaseMvpActivity;
import com.mars.edu.app.library.base.mvp.BasePresenter;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;
import com.mars.edu.app.locallibs.net.NewsItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * create by Chris Chan
 * create on 2019/7/10 0:06
 * use for :
 */
public class NewsActivity extends BaseMvpActivity implements NewsContracts.View {
    @Inject
    NewsPresenter newsPresenter;

    private ViewHolder vh;
    private List<NewsItem> newsItemList;
    private NewsRvAdapter newsRvAdapter;

    @Override
    protected BasePresenter getPresenter() {
        return newsPresenter;
    }

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.fra_news_list;
    }

    @Override
    public void createViewHolder() {
        vh = new ViewHolder(getContentView());
    }

    @Override
    protected void onReady() {
        newsItemList = new ArrayList<>();
        newsRvAdapter = new NewsRvAdapter(this, newsItemList);
        vh.rvNewsList.setLayoutManager(new LinearLayoutManager(this));
        vh.rvNewsList.setAdapter(newsRvAdapter);
        newsPresenter.requestData();//请求网络数据
    }

    @Override
    public void loadMore(List<NewsItem> dataList) {

    }

    @Override
    public void loadData(List<NewsItem> dataList) {

    }

    @Override
    public void updateData(List<NewsItem> dataList) {
        newsRvAdapter.updateData(dataList);
    }

    static
    class ViewHolder {
        @BindView(R.id.news_list)
        RecyclerView rvNewsList;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
