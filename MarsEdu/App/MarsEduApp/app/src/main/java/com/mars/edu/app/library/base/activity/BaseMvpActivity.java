package com.mars.edu.app.library.base.activity;

import android.view.View;

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
    public View createContentView() {
        contentView = createViewHolderByLayoutId();
        return contentView;
    }

    /**
     * 在setcontentView之前通过创建ViewHolder创建view
     * 调用此方法之后，就不可以再用createViewHolder方法
     *
     * @return
     */
    protected abstract View createViewHolderByLayoutId();

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
    protected void onReady() {

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
