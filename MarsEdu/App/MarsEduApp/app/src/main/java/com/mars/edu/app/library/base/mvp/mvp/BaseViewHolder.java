package com.mars.edu.app.base.mvp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;

import butterknife.ButterKnife;

/**
 * @author Chris Chan
 * on 2019/7/5 15:24
 * use for:
 */
public abstract class BaseViewHolder {
    protected View view;

    public BaseViewHolder(Context context) {
        this.view = LayoutInflater.from(context).inflate(getLayoutId(), null);
        ButterKnife.bind(this, view);
    }

    protected abstract int getLayoutId();

    public View getView() {
        return view;
    }
}
