package com.mars.edu.app.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.mars.edu.app.base.mvp.BaseViewHolder;

import butterknife.ButterKnife;

/**
 * create by Chris Chan
 * create on 2019/7/6 1:11
 * use for :
 */
public abstract class BaseActivity<VH extends BaseViewHolder> extends AppCompatActivity {
    protected VH viewHolder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewHolder = createViewHolder();
        setContentView(viewHolder.getView());
        ButterKnife.bind(this);

        initInject();
        initViewAndListener();

    }

    protected abstract VH createViewHolder();

    protected abstract void initInject();

    protected abstract void initViewAndListener();

}
