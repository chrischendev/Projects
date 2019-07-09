package com.mars.edu.app.pages.main;

import android.annotation.SuppressLint;

import com.mars.edu.app.R;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Chris Chan
 * on 2019/7/9 9:09
 * use for:
 */
public class MainPresenter implements MainContracts.Presenter {
    private MainContracts.View view;

    @Inject
    public MainPresenter() {
    }

    @Override
    public void bind(MainContracts.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    @SuppressLint("ResourceType")
    public List<MainNavItem> initMainNavItemList() {
        List<MainNavItem> mainNavItemList = new ArrayList<>();

        mainNavItemList.add(MainNavItem.create("news", R.mipmap.icon_main_news, "资讯"));
        mainNavItemList.add(MainNavItem.create("school", R.mipmap.icon_main_school, "学校"));
        mainNavItemList.add(MainNavItem.create("teacher", R.mipmap.icon_main_teacher, "教师"));
        mainNavItemList.add(MainNavItem.create("studio", R.mipmap.icon_main_stu, "学生"));
        mainNavItemList.add(MainNavItem.create("score", R.mipmap.icon_main_score, "成绩"));
        mainNavItemList.add(MainNavItem.create("activation", R.mipmap.icon_main_activation, "活动"));
        mainNavItemList.add(MainNavItem.create("practice", R.mipmap.icon_main_practice, "实践"));
        mainNavItemList.add(MainNavItem.create("picture", R.mipmap.icon_main_album, "剪影"));
//        mainNavItemList.add(MainNavItem.create("example", R.mipmap.main_item_chat, "考试"));

        return mainNavItemList;
    }
}
