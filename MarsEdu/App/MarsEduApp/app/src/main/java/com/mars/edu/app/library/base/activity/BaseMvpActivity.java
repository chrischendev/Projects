package com.mars.edu.app.library.base.activity;

import com.mars.edu.app.library.base.mvp.BasePresenter;
import com.mars.edu.app.library.base.mvp.BaseView;

/**
 * @author Chris Chan
 * on 2019/7/8 10:25
 * use for: mvp模式封装
 */
public abstract class BaseMvpActivity extends BaseInjectActivity implements BaseView {

    protected abstract BasePresenter getPresenter();

    @Override
    public void init() {
        super.init();
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
    public void preSetContentView() {

    }

    @Override
    public void postContentView() {
        super.postContentView();
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
}
