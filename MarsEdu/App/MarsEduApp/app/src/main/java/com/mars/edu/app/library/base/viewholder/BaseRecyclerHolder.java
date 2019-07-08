package com.mars.edu.app.library.base.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Chris Chen on 2017/7/3 17:19.
 * Explain:RecyclerView.ViewHolder的封装基类，依赖于Butterknife
 */

public abstract class BaseRecyclerHolder<D> extends RecyclerView.ViewHolder {
    protected View itemView;
    protected Context mContext;

    public BaseRecyclerHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        this.itemView = itemView;
        ButterKnife.bind(this, itemView);
    }

    /**
     * 更新视图
     *
     * @param item
     */
    protected abstract void refreshView(D item);
}
