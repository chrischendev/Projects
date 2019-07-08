package com.mars.edu.app.pages.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.mars.edu.app.R;
import com.mars.edu.app.library.base.adapter.BaseRecyclerAdapter;
import com.mars.edu.app.pages.login.LoginActivity;
import com.mars.edu.app.pages.teacher.TeacherActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, BaseRecyclerAdapter.OnItemClickListener<MainNavItem> {
    private ViewHolder vh;
    private MenuHeaderViewHolder mVh;
    private MainRvAdapter mainRvAdapter;
    private List<MainNavItem> mainNavItemList;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = getLayoutInflater().inflate(R.layout.act_main, null);
        setContentView(view);
        vh = new ViewHolder(view);

        //工具条
        setSupportActionBar(vh.toolbar);

        //浮动按钮
        vh.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "替换为你自己的动作", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //侧滑菜单
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, vh.drawer, vh.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        vh.drawer.addDrawerListener(toggle);
        toggle.syncState();
        vh.navView.setNavigationItemSelectedListener(this);
        //侧滑菜单头部控件
        View navHeaderView = vh.navView.getHeaderView(0);
        mVh = new MenuHeaderViewHolder(navHeaderView);
        ////读取登录用户
        SharedPreferences localuser = getSharedPreferences("localuser", Context.MODE_PRIVATE);
        String username = localuser.getString("username", null);
        //String password = localuser.getString("password", null);
        if (null == username) {
            Glide.with(this).load(R.mipmap.main_item_chat).into(mVh.ivMainUserPhoto);
            mVh.tvMainUserName.setVisibility(View.GONE);
            mVh.tvMainUserEmail.setVisibility(View.GONE);
            mVh.tvMainLoginReg.setVisibility(View.VISIBLE);
            mVh.tvMainLoginReg.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }
            });
        } else {
            Glide.with(this).load(R.mipmap.main_item_chat).into(mVh.ivMainUserPhoto);
            mVh.tvMainUserName.setVisibility(View.VISIBLE);
            mVh.tvMainUserEmail.setVisibility(View.VISIBLE);
            mVh.tvMainUserName.setText(username);
            mVh.tvMainUserEmail.setText("chris@163.com");
            mVh.tvMainLoginReg.setVisibility(View.GONE);
        }

        //上方广告图片
        Glide.with(this).load(R.mipmap.fj001).into(vh.ivMainAd);

        //功能导航
        vh.rvMainNav.setLayoutManager(new GridLayoutManager(this, 4));
        mainNavItemList = new ArrayList<>();
        mainNavItemList.add(MainNavItem.create("school", R.mipmap.main_item_chat, "学校"));
        mainNavItemList.add(MainNavItem.create("teacher", R.mipmap.main_item_chat, "教师"));
        mainNavItemList.add(MainNavItem.create("student", R.mipmap.main_item_chat, "学生"));
        mainNavItemList.add(MainNavItem.create("activation", R.mipmap.main_item_chat, "活动"));
        mainNavItemList.add(MainNavItem.create("score", R.mipmap.main_item_chat, "成绩"));
        mainNavItemList.add(MainNavItem.create("interest", R.mipmap.main_item_chat, "兴趣"));
        mainNavItemList.add(MainNavItem.create("practice", R.mipmap.main_item_chat, "实践"));
        mainRvAdapter = new MainRvAdapter(this, mainNavItemList);
        mainRvAdapter.setOnItemClickListener(this);
        vh.rvMainNav.setAdapter(mainRvAdapter);
        mainNavItemList.add(MainNavItem.create("photo", R.mipmap.main_item_chat, "剪影"));
        mainRvAdapter.notifyDataSetChanged();
    }

    @Override
    public void onBackPressed() {
        if (vh.drawer.isDrawerOpen(GravityCompat.START)) {
            vh.drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_user_info) {
            startActivity(new Intent(this, TeacherActivity.class));
        } else if (id == R.id.nav_wallet) {

        } else if (id == R.id.nav_album) {

        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_contact) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onItemClick(View itemView, int position, MainNavItem item) {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show();
        switch (item.code) {
            case "teacher":
                startActivity(new Intent(this, TeacherActivity.class));
        }
    }

    static
    class ViewHolder {
        @BindView(R.id.toolbar)
        Toolbar toolbar;
        @BindView(R.id.iv_main_ad)
        ImageView ivMainAd;
        @BindView(R.id.rv_main_nav)
        RecyclerView rvMainNav;
        @BindView(R.id.fab)
        FloatingActionButton fab;
        @BindView(R.id.nav_view)
        NavigationView navView;
        @BindView(R.id.drawer_layout)
        DrawerLayout drawer;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    static
    class MenuHeaderViewHolder {
        @BindView(R.id.iv_main_user_photo)
        ImageView ivMainUserPhoto;
        @BindView(R.id.tv_main_login_reg)
        TextView tvMainLoginReg;
        @BindView(R.id.tv_main_user_name)
        TextView tvMainUserName;
        @BindView(R.id.tv_main_user_email)
        TextView tvMainUserEmail;

        MenuHeaderViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
