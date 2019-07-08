package com.mars.edu.app.library.base.activity;

import android.annotation.SuppressLint;
import android.support.annotation.IdRes;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @author Chris Chan
 * on 2019/7/8 10:29
 * use for: 包含butterknife基本处理的封装
 */
public abstract class BaseBindActivity extends BaseActivity {
    @Override
    public View createContentView() {
        @SuppressLint("ResourceType") View view = getLayoutInflater().inflate(getLayoutId(), null);
        return view;
    }

    /**
     * 返回主要布局资源ID
     *
     * @return
     */
    public abstract @IdRes
    int getLayoutId();

    @Override
    public void postContentView() {
        ButterKnife.bind(this);
        createViewHolder();
        createDataHolder();
        createListenerHolder();
        init();
    }

    /**
     * 初始化操作
     */
    public abstract void init();

    /**
     * 创建监听器持有者
     */
    public void createListenerHolder() {
    }

    ;

    /**
     * 创建数据持有者
     */
    public void createDataHolder() {
    }

    ;

    /**
     * 创建ViewHolder
     */
    public void createViewHolder() {
    }

    ;
}
