package com.chris.base.library.base.fragment;

import android.os.Bundle;
import android.view.View;

/**
 * @author Chris Chan
 * on 2019/7/9 17:12
 * use for:
 */
public abstract class BaseInjectFragment extends BaseBindFragment {
    @Override
    protected void preViewCreate(View view, Bundle savedInstanceState) {
        initInject();
    }

    protected abstract void initInject();
}
