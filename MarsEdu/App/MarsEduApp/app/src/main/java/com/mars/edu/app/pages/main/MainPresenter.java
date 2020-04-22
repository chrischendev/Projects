package com.mars.edu.app.pages.main;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chris.base.library.base.adapter.BaseRecyclerAdapter;
import com.google.android.material.navigation.NavigationView;
import com.mars.edu.app.R;
import com.mars.edu.app.pages.home.HomeActivity;
import com.mars.edu.app.pages.news.NewsActivity;
import com.mars.edu.app.pages.picture.PictureActivity;
import com.mars.edu.app.pages.teacher.TeacherActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * @author Chris Chan
 * on 2019/7/9 9:09
 * use for:
 */
public class MainPresenter implements MainContracts.Presenter, NavigationView.OnNavigationItemSelectedListener, BaseRecyclerAdapter.OnItemClickListener<MainNavItem> {
    private MainContracts.View view;
    private MainActivity activity;

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

    public void setActivity(MainActivity activity) {
        this.activity = activity;
    }

    /**
     * 跳转页面
     *
     * @param targetActivityClass
     */
    private void startActivity(Class<? extends Activity> targetActivityClass) {
        activity.startActivity(new Intent(activity, targetActivityClass));
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
        mainNavItemList.add(MainNavItem.create("chat", R.mipmap.icon_main_album, "聊天"));
        mainNavItemList.add(MainNavItem.create("video", R.mipmap.icon_main_album, "视频"));
//        mainNavItemList.add(MainNavItem.create("example", R.mipmap.icon_main_chat, "考试"));

        return mainNavItemList;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_user_info) {
            startActivity(HomeActivity.class);
        } else if (id == R.id.nav_wallet) {

        } else if (id == R.id.nav_album) {
            ARouter.getInstance().build("/app/AlbumActivity").navigation();
        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {
            //ARouter.getInstance().build("/video/VideoActivity").navigation();
        } else if (id == R.id.nav_contact) {
            //ARouter.getInstance().build("/chat/ChatActivity").navigation();
        }

        DrawerLayout drawer = activity.findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(View itemView, int position, MainNavItem item) {
        switch (item.code) {
            case "news":
                startActivity(NewsActivity.class);
                break;
            case "school":
                startActivity(HomeActivity.class);
                break;
            case "teacher":
                startActivity(TeacherActivity.class);
                break;
            case "practice":
                startActivity(TeacherActivity.class);
                break;
            case "picture":
                startActivity(PictureActivity.class);
                break;
            case "chat":
                //startActivity(ChatActivity.class);
                ARouter.getInstance().build("/chat/ChatActivity").navigation();
                break;
            case "video":
                //startActivity(video);
                ARouter.getInstance().build("/video/VideoActivity").navigation();
                break;
            default:
                break;
        }
    }
}
