package com.mars.edu.app.library.base.fragment;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * @author Chris Chan
 * on 2019/7/9 17:08
 * use for:
 */
public abstract class BaseBindFragment extends BaseFragment {
    protected Unbinder unbinder;

    @Override
    protected void postViewCreated(View view, Bundle savedInstanceState) {
        unbinder = ButterKnife.bind(this, view);
        createViewHolder();
        createDataHolder();
        createListenerHolder();
        init(view,savedInstanceState);
    }

    protected abstract void createViewHolder();

    protected abstract void createDataHolder();

    protected abstract void createListenerHolder();

    protected abstract void init(View view, Bundle savedInstanceState);

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (null != this.unbinder) {
            this.unbinder.unbind();
        }
    }
}
