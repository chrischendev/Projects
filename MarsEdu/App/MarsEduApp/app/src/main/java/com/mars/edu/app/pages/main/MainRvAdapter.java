package com.mars.edu.app.pages.main;

import android.content.Context;
import android.view.View;

import com.chris.base.library.base.adapter.BaseRecyclerAdapter;
import com.mars.edu.app.R;

import java.util.List;

/**
 * @author Chris Chan
 * on 2019/7/8 11:15
 * use for:
 */
public class MainRvAdapter extends BaseRecyclerAdapter<MainNavItem, MainRvViewHolder> {
    public MainRvAdapter(Context context, List<MainNavItem> mData) {
        super(context, mData);
    }

    @Override
    protected int layoutId() {
        return R.layout.item_of_main_nav;
    }

    @Override
    protected MainRvViewHolder createViewHolder(View itemView) {
        return new MainRvViewHolder(context, itemView);
    }

    @Override
    protected void refreshItemView(MainRvViewHolder holder, MainNavItem item) {
        holder.refreshView(item);
    }

}
