package com.mars.edu.app.pages.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chris.base.library.base.adapter.BaseRecyclerAdapter;
import com.chris.base.library.base.fragment.BaseMvpFragment;
import com.chris.base.library.base.mvp.BasePresenter;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerFragmentComponent;
import com.mars.edu.app.locallibs.net.NewsItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Chris Chan
 * on 2019/7/10 9:42
 * use for:
 */
public class NewsFragment extends BaseMvpFragment implements NewsContracts.View, BaseRecyclerAdapter.OnItemClickListener<NewsItem> {
    public static final String ARG_KEY_TYPE = "type";
    public static final String ARG_KEY_TYPE_NAME = "typeName";
    @Inject
    NewsPresenter newsPresenter;

    private ViewHolder vh;
    private List<NewsItem> newsItemList;
    private NewsRvAdapter newsRvAdapter;

    /**
     * 实例化
     *
     * @param type
     * @param typeName
     * @return
     */
    public static NewsFragment getInstance(String type, String typeName) {
        NewsFragment newsFragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_KEY_TYPE, type);
        args.putString(ARG_KEY_TYPE_NAME, typeName);
        newsFragment.setArguments(args);
        return newsFragment;
    }

    @Override
    protected BasePresenter getPresenter() {
        return newsPresenter;
    }

    @Override
    protected void initInject() {
        DaggerFragmentComponent.create().inject(this);
    }

    @Override
    protected int layoutId() {
        return R.layout.fra_news_list;
    }

    @Override
    protected void createViewHolder() {
        vh = new ViewHolder(getContentView());
    }

    @Override
    protected void onReady() {
        newsItemList = new ArrayList<>();
        newsRvAdapter = new NewsRvAdapter(getOwnContext(), newsItemList);
        newsRvAdapter.setOnItemClickListener(this);
        vh.rvNewsList.setLayoutManager(new LinearLayoutManager(getOwnContext()));
        vh.rvNewsList.setAdapter(newsRvAdapter);
        newsPresenter.getNewsList(getArguments().getString(ARG_KEY_TYPE));//请求网络数据
    }

    @Override
    public void loadData(List<NewsItem> dataList) {

    }

    @Override
    public void updateData(List<NewsItem> dataList) {
        newsRvAdapter.updateData(dataList);
    }

    @Override
    public void loadMore(List<NewsItem> dataList) {

    }

    public String getTypeName() {
        return getArguments().getString(ARG_KEY_TYPE_NAME);
    }

    @Override
    public void onItemClick(View itemView, int position, NewsItem item) {
        Intent intent = new Intent(getOwnContext(), NewsDetailActivity.class);
        intent.putExtra("url", item.url);
        intent.putExtra("title", item.title);
        startActivity(intent);
    }

    static
    class ViewHolder {
        @BindView(R.id.rv_news_list)
        RecyclerView rvNewsList;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
