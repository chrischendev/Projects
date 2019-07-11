package com.mars.edu.app.pages.news;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

import com.chris.base.library.base.activity.BaseInjectActivity;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Chris Chan
 * on 2019/7/10 10:54
 * use for:
 */
public class NewsDetailActivity extends BaseInjectActivity {
    private ViewHolder vh;

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.act_news_detail;
    }

    @Override
    public void createViewHolder() {
        vh = new ViewHolder(getContentView());
    }

    @Override
    public void init(Bundle savedInstanceState) {
        vh.webNewsDetail = findViewById(R.id.web_news_detail);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        vh.webNewsDetail.loadUrl(url);
        setTitle(title);
    }

    @Override
    protected void onReady() {

    }

    static
    class ViewHolder {
        @BindView(R.id.web_news_detail)
        WebView webNewsDetail;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
