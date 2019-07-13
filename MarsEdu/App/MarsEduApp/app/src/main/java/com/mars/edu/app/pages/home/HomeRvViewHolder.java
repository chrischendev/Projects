package com.mars.edu.app.pages.home;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.chris.base.library.base.viewholder.BaseRecyclerHolder;
import com.mars.edu.app.R;

import butterknife.BindView;

/**
 * @author Chris Chan
 * on 2019/7/9 11:18
 * use for:
 */
public class HomeRvViewHolder extends BaseRecyclerHolder<HomeModels.NavItem> {
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public HomeRvViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @SuppressLint("ResourceType")
    @Override
    protected void refreshView(HomeModels.NavItem item) {
        itemView.setBackgroundColor(item.bgColorId);
        tvTitle.setText(item.title);
    }
}
