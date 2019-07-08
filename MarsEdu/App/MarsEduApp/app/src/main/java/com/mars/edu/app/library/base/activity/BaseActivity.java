package com.mars.edu.app.library.base.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * @author Chris Chan
 * on 2019/7/8 10:16
 * use for:
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 主要内容布局控件
     */
    public View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preSetContentView();
        contentView = createContentView();
        setContentView(contentView);
        postContentView();
        onReady();
    }

    /**
     * 一切都准备好了
     */
    protected abstract void onReady();

    /**
     * 在设置完主要内容控件之后执行
     */
    public abstract void postContentView();

    /**
     * 创建主要内容布局
     * 一般在这里把布局文件实例化为控件
     *
     * @return
     */
    public abstract View createContentView();

    /**
     * 在设置主要内容布局之前执行
     */
    public abstract void preSetContentView();

    /**
     * 获取主要内容布局
     *
     * @return
     */
    public View getContentView() {
        return contentView;
    }
}
