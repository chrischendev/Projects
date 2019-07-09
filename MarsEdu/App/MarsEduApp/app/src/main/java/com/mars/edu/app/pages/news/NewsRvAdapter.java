package com.mars.edu.app.pages.news;

import android.content.Context;
import android.view.View;

import com.mars.edu.app.R;
import com.mars.edu.app.library.base.adapter.BaseRecyclerAdapter;
import com.mars.edu.app.locallibs.net.NewsItem;

import java.util.List;

/**
 * create by Chris Chan
 * create on 2019/7/10 0:33
 * use for :
 */
public class NewsRvAdapter extends BaseRecyclerAdapter<NewsItem, NewsRvViewHolder> {
    public NewsRvAdapter(Context context, List<NewsItem> dataList) {
        super(context, dataList);
    }

    @Override
    protected int layoutId() {
        return R.layout.item_news_news;
    }

    @Override
    protected NewsRvViewHolder createViewHolder(View itemView) {
        return new NewsRvViewHolder(context, itemView);
    }

    @Override
    protected void refreshItemView(NewsRvViewHolder holder, NewsItem item) {
        holder.refreshView(item);
    }
}
