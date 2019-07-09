package com.mars.edu.app.pages.main;

import android.annotation.SuppressLint;
import android.support.annotation.DrawableRes;
import android.support.annotation.IdRes;
import android.support.annotation.RawRes;

/**
 * @author Chris Chan
 * on 2019/7/8 11:16
 * use for: 主界面导航列表项
 */
public class MainNavItem {
    public String code;//用以进行逻辑匹配
    public @IdRes
    int imgId;
    public String imgUrl;
    public String title;

    public MainNavItem() {
    }

    public MainNavItem(String code, @IdRes int imgId, String title) {
        this.code = code;
        this.imgId = imgId;
        this.title = title;
    }

    public MainNavItem(String code, String imgUrl, String title) {
        this.code = code;
        this.imgUrl = imgUrl;
        this.title = title;
    }

    @SuppressLint("ResourceType")
    public static MainNavItem create(String code, @RawRes @DrawableRes int imgId, String title) {
        return new MainNavItem(code, imgId, title);
    }
}
