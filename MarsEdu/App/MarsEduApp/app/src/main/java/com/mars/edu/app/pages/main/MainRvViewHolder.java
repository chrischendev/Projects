package com.mars.edu.app.pages.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mars.edu.app.R;
import com.mars.edu.app.library.base.viewholder.BaseRecyclerHolder;

import butterknife.BindView;

/**
 * @author Chris Chan
 * on 2019/7/8 11:14
 * use for:
 */
public class MainRvViewHolder extends BaseRecyclerHolder<MainNavItem> {

    @BindView(R.id.iv_pic)
    ImageView ivPic;
    @BindView(R.id.tv_title)
    TextView tvTitle;

    public MainRvViewHolder(Context context, View itemView) {
        super(context, itemView);
        //itemView.setBackgroundColor(context.getResources().getColor(R.color.colorPrimary));
    }

    @SuppressLint("ResourceType")
    @Override
    protected void refreshView(MainNavItem item) {
        Glide.with(context).load(item.imgId).into(ivPic);
        tvTitle.setText(item.title);
    }


//    @OnClick({R.id.iv_pic, R.id.tv_title})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.iv_pic:
//                break;
//            case R.id.tv_title:
//                break;
//        }
//    }
}
