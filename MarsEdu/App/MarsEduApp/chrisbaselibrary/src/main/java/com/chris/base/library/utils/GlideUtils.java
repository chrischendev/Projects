package com.chris.base.library.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.annotation.RawRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chris.base.library.manager.UtilsManager;

/**
 * create by Chris Chan
 * create on 2019/7/9 22:19
 * use for :
 */
public class GlideUtils extends UtilsManager {
    public static void load(Context context, @RawRes @DrawableRes int imgId, ImageView imageView) {
        Glide.with(context).load(imgId).into(imageView);
    }

    public static void load(Context context, Uri uri, ImageView imageView) {
        Glide.with(context).load(uri).into(imageView);
    }

    public static void load(Context context, String imgUrl, ImageView imageView) {
        Glide.with(context).load(imgUrl).into(imageView);
    }

    public static void load(Context context, Bitmap bitmap, ImageView imageView) {
        Glide.with(context).load(bitmap).into(imageView);
    }

    public static void load(Context context, Drawable drawable, ImageView imageView) {
        Glide.with(context).load(drawable).into(imageView);
    }

}
