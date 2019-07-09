package com.mars.edu.app.pages.news;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mars.edu.app.R;
import com.mars.edu.app.library.base.viewholder.BaseRecyclerHolder;
import com.mars.edu.app.library.utils.GlideUtils;
import com.mars.edu.app.locallibs.net.NewsItem;

import butterknife.BindView;

/**
 * create by Chris Chan
 * create on 2019/7/10 0:29
 * use for :
 */
public class NewsRvViewHolder extends BaseRecyclerHolder<NewsItem> {
    @BindView(R.id.news_item_img)
    ImageView newsItemImg;
    @BindView(R.id.news_item_title)
    TextView newsItemTitle;
    @BindView(R.id.news_item_date)
    TextView newsItemDate;
    @BindView(R.id.news_item_author)
    TextView newsItemAuthor;
    @BindView(R.id.news_item_url)
    TextView newsItemUrl;

    public NewsRvViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    protected void refreshView(NewsItem item) {
        GlideUtils.load(context, item.thumbnail_pic_s, newsItemImg);
        newsItemTitle.setText(item.title);
        newsItemAuthor.setText(item.author_name);
        newsItemUrl.setText(item.url);
        newsItemDate.setText(item.date);
    }
}
