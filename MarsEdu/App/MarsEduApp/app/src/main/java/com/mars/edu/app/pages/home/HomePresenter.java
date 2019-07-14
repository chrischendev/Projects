package com.mars.edu.app.pages.home;

import com.mars.edu.app.R;
import com.mars.edu.app.pages.main.MainNavItem;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Chris Chan
 * on 2019/7/9 10:38
 * use for:
 */
public class HomePresenter implements HomeContracts.Presenter {
    private HomeContracts.View view;

    @Inject
    public HomePresenter() {
    }

    @Override
    public void bind(HomeContracts.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    public List<MainNavItem> initMainNavItemList() {
        List<MainNavItem> mainNavItemList = new ArrayList<>();

        mainNavItemList.add(MainNavItem.create("school", R.mipmap.icon_main_chat, "学校"));
        mainNavItemList.add(MainNavItem.create("teacher", R.mipmap.icon_main_chat, "教师"));
        mainNavItemList.add(MainNavItem.create("studio", R.mipmap.icon_main_chat, "学生"));
        mainNavItemList.add(MainNavItem.create("score", R.mipmap.icon_main_chat, "成绩"));
        mainNavItemList.add(MainNavItem.create("activation", R.mipmap.icon_main_chat, "活动"));
        mainNavItemList.add(MainNavItem.create("practice", R.mipmap.icon_main_chat, "成绩"));
        mainNavItemList.add(MainNavItem.create("picture", R.mipmap.icon_main_chat, "成绩"));
        mainNavItemList.add(MainNavItem.create("example", R.mipmap.icon_main_chat, "考试"));

        return mainNavItemList;
    }

}
