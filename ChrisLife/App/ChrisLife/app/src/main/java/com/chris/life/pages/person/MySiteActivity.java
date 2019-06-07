package com.chris.life.pages.person;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.chris.life.R;

public class MySiteActivity extends AppCompatActivity {
    private WebView webMySite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_my_site);

        initView();
    }

    private void initView() {
        webMySite = findViewById(R.id.web_my_site);
        webMySite.loadUrl("http://www.chrischen.com.cn/");
        setTitle("爱拼才会赢");
    }
}
