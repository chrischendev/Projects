package com.chris.base.library.base.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.chris.base.library.base.mvp.BasePresenter;
import com.chris.base.library.base.mvp.BaseView;

/**
 * @author Chris Chan
 * on 2019/7/9 17:14
 * use for:
 */
public abstract class BaseMvpFragment extends BaseInjectFragment implements BaseView {
    @Override
    protected void postViewCreated(View view, Bundle savedInstanceState) {
        super.postViewCreated(view, savedInstanceState);
        if (null != getPresenter()) {
            getPresenter().bind(this);
        }
        onReady();
    }

    protected void onReady() {
    }

    protected abstract BasePresenter getPresenter();

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != getPresenter()) {
            getPresenter().unbind();
        }
    }

    @Override
    public Context getOwnContext() {
        return getBaseContext();
    }

    @Override
    protected void createViewHolder() {

    }

    @Override
    protected void createDataHolder() {

    }

    @Override
    protected void createListenerHolder() {

    }

    @Override
    protected void init(View view, Bundle savedInstanceState) {

    }
}
