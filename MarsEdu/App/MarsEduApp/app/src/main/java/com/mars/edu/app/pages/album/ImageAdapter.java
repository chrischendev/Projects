package com.mars.edu.app.pages.album;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;

/**
 * create by Chris Chan
 * create on 2019/9/10 17:19
 * use for :
 */
public class ImageAdapter extends BaseAdapter {
    private Context context;
    private int[] imagesReses;

    public ImageAdapter(Context context, int[] imagesReses) {
        this.context = context;
        this.imagesReses = imagesReses;
    }

    @Override
    public int getCount() {
        return imagesReses == null ? 0 : imagesReses.length;
    }

    @Override
    public Object getItem(int position) {
        return imagesReses == null ? null : imagesReses[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView iv=null;
        if (null==iv){
            iv=new ImageView(context);
            Gallery.LayoutParams params=new Gallery.LayoutParams(1000,1000);
            iv.setLayoutParams(params);
        }
        iv.setImageResource(imagesReses[position]);
        return iv;
    }
}
