package com.chris.life.pages.main;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.chris.life.R;

public class MainHolder {
    private Context context;
    private View view;
    private ImageView ivImg;
    private TextView tvTitle;

    public MainHolder(Context context, View view) {
        this.context = context;
        this.view = view;

        ivImg = view.findViewById(R.id.item_main_img);
        tvTitle = view.findViewById(R.id.item_main_title);
    }

    public void refreshView(MainItem item) {
        //Glide.with(context).load(R.mipmap.ic_launcher_round).into(ivImg);
        ivImg.setImageResource(item.imgId);
        tvTitle.setText(item.title);
    }
}
