package com.chris.base.library.base.activity;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Chris Chan
 * on 2019/7/8 10:29
 * use for: 包含butterknife基本处理的封装
 */
public abstract class BaseBindActivity extends BaseActivity {
    protected Unbinder unbinder;

    @Override
    public View createContentView() {
        View view = getLayoutInflater().inflate(layoutId(), null);
        return view;
    }

    /**
     * 返回主要布局资源ID
     *
     * @return
     */
    public abstract @LayoutRes
    int layoutId();



    @Override
    public void postContentView(Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this);
        createViewHolder();
        createDataHolder();
        createListenerHolder();
        init(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != this.unbinder) {
            this.unbinder.unbind();
        }
    }

    /**
     * 初始化操作
     *
     * @param savedInstanceState
     */
    public abstract void init(Bundle savedInstanceState);

    /**
     * 创建监听器持有者
     */
    public void createListenerHolder() {
    }

    /**
     * 创建数据持有者
     */
    public void createDataHolder() {
    }

    /**
     * 创建ViewHolder
     */
    public void createViewHolder() {
    }

}
