package com.chris.life.pages.read.news;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.chris.life.R;

public class NewsDetailActivity extends AppCompatActivity {

    private WebView webNewsDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_news_detail);

        initView();
    }

    private void initView() {
        webNewsDetail = findViewById(R.id.web_news_detail);

        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        String title = intent.getStringExtra("title");

        webNewsDetail.loadUrl(url);
        setTitle(title);
    }
}
