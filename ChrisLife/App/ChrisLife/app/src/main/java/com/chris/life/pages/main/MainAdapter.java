package com.chris.life.pages.main;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.chris.life.R;

import java.util.List;

public class MainAdapter extends BaseAdapter {
    private List<MainItem> itemList;
    private Context context;

    public MainAdapter(List<MainItem> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return itemList == null ? 0 : itemList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemList == null ? null : itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        MainHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_main, null);
            //convertView.setBackgroundColor(Color.parseColor("#4CAF50"));
            holder = new MainHolder(context, convertView);
            convertView.setTag(holder);
        } else {
            holder = (MainHolder) convertView.getTag();
        }

        holder.refreshView(itemList.get(position));
        return convertView;
    }
}
