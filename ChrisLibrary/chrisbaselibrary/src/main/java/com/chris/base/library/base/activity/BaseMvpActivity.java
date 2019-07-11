package com.chris.base.library.base.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.chris.base.library.base.mvp.BasePresenter;
import com.chris.base.library.base.mvp.BaseView;

/**
 * @author Chris Chan
 * on 2019/7/8 10:25
 * use for: mvp模式封装
 */
public abstract class BaseMvpActivity extends BaseInjectActivity implements BaseView {

    protected abstract BasePresenter getPresenter();

    /**
     * 默认使用layoutId创建
     * 否则使用ViewHolder创建
     *
     * @return
     */
    @Override
    public View createContentView() {
        View contentView = createViewHolderByLayoutId();
        if (null == contentView) {
            this.contentView = super.createContentView();
        }
        return this.contentView;
    }

    /**
     * 在setcontentView之前通过创建ViewHolder创建view
     * 调用此方法之后，就不可以再用createViewHolder方法
     *
     * @return
     */
    protected View createViewHolderByLayoutId() {
        return null;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        if (null != getPresenter()) {
            getPresenter().bind(this);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != getPresenter()) {
            getPresenter().unbind();
        }
    }

    @Override
    public void preSetContentView(Bundle savedInstanceState) {

    }

    @Override
    protected void onReady() {

    }

    @Override
    public void postContentView(Bundle savedInstanceState) {
        super.postContentView(savedInstanceState);
    }

    @Override
    public void createListenerHolder() {
        super.createListenerHolder();
    }

    @Override
    public void createDataHolder() {
        super.createDataHolder();
    }

    @Override
    public void createViewHolder() {
        super.createViewHolder();
    }

    @Override
    public Context getOwnContext() {
        return this;
    }
}
