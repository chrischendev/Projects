package com.mars.edu.app.pages.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.launcher.ARouter;
import com.bumptech.glide.Glide;
import com.chris.base.library.base.activity.BaseMvpActivity;
import com.chris.base.library.base.adapter.BaseRecyclerAdapter;
import com.chris.base.library.base.mvp.BasePresenter;
import com.chris.base.library.utils.GlideUtils;
import com.chris.base.library.utils.SPUtils;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;
import com.mars.edu.app.pages.home.HomeActivity;
import com.mars.edu.app.pages.login.LoginActivity;
import com.mars.edu.app.pages.news.NewsActivity;
import com.mars.edu.app.pages.scan.ScanActivity;
import com.mars.edu.app.pages.teacher.TeacherActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity implements NavigationView.OnNavigationItemSelectedListener, MainContracts.View, BaseRecyclerAdapter.OnItemClickListener<MainNavItem> {

    @Inject
    MainPresenter mainPresenter;

    private List<MainNavItem> mainNavItemList;
    private MainRvAdapter mainRvAdapter;
    private ViewHolder vh;
    private NavHeaderViewHolder nvh;

    @Override
    protected BasePresenter getPresenter() {
        return mainPresenter;
    }

    @Override
    protected View createViewHolderByLayoutId() {
        contentView = getLayoutInflater().inflate(layoutId(), null);
        vh = new ViewHolder(contentView);
        return contentView;
    }

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.act_main;
    }

    @Override
    public void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        //工具条
        setSupportActionBar(vh.toolbar);
        //浮动按钮
        initFloatButton();
        //侧滑菜单
        initDrawer();
        //主体布局
        initMainLayout();
    }

    private void initMainLayout() {
        //广告
        Glide.with(this).load(R.mipmap.fj001).into(vh.ivMainAd);

        //数据
        mainNavItemList = mainPresenter.initMainNavItemList();

        //适配器
        mainRvAdapter = new MainRvAdapter(this, mainNavItemList);
        mainRvAdapter.setOnItemClickListener(this);
        //显示控件
        vh.rvMainNav.setLayoutManager(new GridLayoutManager(this, 4));
        vh.rvMainNav.setAdapter(mainRvAdapter);

    }

    private void initDrawer() {
        //开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, vh.drawer, vh.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        vh.drawer.addDrawerListener(toggle);
        toggle.syncState();
        vh.navView.setNavigationItemSelectedListener(this);
        //侧滑菜单头部控件数据持有者
        nvh = new NavHeaderViewHolder(vh.navView.getHeaderView(0));
        nvh.tvMainLoginReg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityFromTo(MainActivity.this, LoginActivity.class);
            }
        });

        //判断登录状态
        String username = SPUtils.read("username", null);
        if (null == username) {
            nvh.tvMainLoginReg.setVisibility(View.VISIBLE);
            nvh.tvMainUserName.setVisibility(View.GONE);
            nvh.tvMainUserEmail.setVisibility(View.GONE);

            GlideUtils.load(this, R.mipmap.nav_header_photo, nvh.ivMainUserPhoto);
        } else {
            nvh.tvMainLoginReg.setVisibility(View.GONE);
            nvh.tvMainUserName.setVisibility(View.VISIBLE);
            nvh.tvMainUserEmail.setVisibility(View.VISIBLE);

            GlideUtils.load(this, R.mipmap.nav_header_photo_1, nvh.ivMainUserPhoto);
            nvh.tvMainUserName.setText(username);
            nvh.tvMainUserEmail.setText("chris@mars.com");
        }
    }

    @SuppressLint("RestrictedApi")
    private void initFloatButton() {
        vh.fab.setVisibility(View.GONE);
        vh.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_qrcode:
                startActivity(ScanActivity.class);
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.nav_user_info) {
            startActivity(HomeActivity.class);
        } else if (id == R.id.nav_wallet) {

        } else if (id == R.id.nav_album) {
            Toast.makeText(this, "跳转到相册", Toast.LENGTH_SHORT).show();
            //startActivity(AlbumActivity.class);
            ARouter.getInstance().build("/app/AlbumActivity").navigation();
        } else if (id == R.id.nav_tools) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_contact) {
            Toast.makeText(this, "跳转到聊天", Toast.LENGTH_SHORT).show();
            //startActivity(com.mars.edu.chat.ChatActivity.class);
            ARouter.getInstance().build("/chat/ChatActivity").navigation();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
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
            default:
                break;
        }
    }

    /**
     * 主要控件
     */
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

    /**
     * 侧滑菜单头部控件
     */
    static
    class NavHeaderViewHolder {
        @BindView(R.id.iv_main_user_photo)
        ImageView ivMainUserPhoto;
        @BindView(R.id.tv_main_login_reg)
        TextView tvMainLoginReg;
        @BindView(R.id.tv_main_user_name)
        TextView tvMainUserName;
        @BindView(R.id.tv_main_user_email)
        TextView tvMainUserEmail;

        NavHeaderViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
