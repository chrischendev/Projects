package com.mars.edu.app.pages.news;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

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
    private ProgressDialog progressDialog;

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
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeAsUpIndicator(R.mipmap.icon_arrow_white_left_128_01);
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        WebSettings settings = vh.webNewsDetail.getSettings();
        settings.setJavaScriptEnabled(true);


        vh.webNewsDetail.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }

        });

        vh.webNewsDetail.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                vh.pbPage.setProgress(newProgress);
                if (newProgress==100){
                    closeProgressDialog();
                }else {
                    openProgressDialog(newProgress);
                }
            }

        });

    }

    private void closeProgressDialog() {
        if (progressDialog!=null){
            progressDialog.dismiss();
            progressDialog=null;
            Toast.makeText(this, "加载完成", Toast.LENGTH_SHORT).show();
        }
    }

    private void openProgressDialog(int newProgress) {
        if (progressDialog==null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setTitle("正在加载...");
            progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            progressDialog.show();
        }

        progressDialog.setProgress(newProgress);
    }

    /**
     * 页面返回
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode==KeyEvent.KEYCODE_BACK){
            if (vh.webNewsDetail.canGoBack()){
                vh.webNewsDetail.goBack();
                return true;
            }
        }
        return super.onKeyUp(keyCode, event);
    }

    @Override
    public void onBackPressed() {
        Toast.makeText(this, "返回", Toast.LENGTH_SHORT).show();
        super.onBackPressed();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onReady() {

    }

    static
    class ViewHolder {
        @BindView(R.id.web_news_detail)
        WebView webNewsDetail;
        @BindView(R.id.pb_page)
        ProgressBar pbPage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
