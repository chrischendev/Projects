package com.mars.edu.app.pages.main;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chris.base.library.base.activity.BaseMvpActivity;
import com.chris.base.library.base.mvp.BasePresenter;
import com.chris.base.library.utils.GlideUtils;
import com.chris.base.library.utils.SPUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;
import com.mars.edu.app.pages.login.LoginActivity;
import com.mars.edu.app.pages.scan.ScanActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseMvpActivity implements MainContracts.View {

    @Inject
    MainPresenter mainPresenter;

    private List<MainNavItem> mainNavItemList;
    private MainRvAdapter mainRvAdapter;
    private ViewHolder vh;
    private NavHeaderViewHolder nvh;

    @Override
    protected BasePresenter getPresenter() {
        mainPresenter.setActivity(this);
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
        mainRvAdapter.setOnItemClickListener(mainPresenter);
        //显示控件
        vh.rvMainNav.setLayoutManager(new GridLayoutManager(this, 4));
        vh.rvMainNav.setAdapter(mainRvAdapter);

    }

    private void initDrawer() {
        //开关
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, vh.drawer, vh.toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        vh.drawer.addDrawerListener(toggle);
        toggle.syncState();
        //vh.navView.setNavigationItemSelectedListener(this);
        vh.navView.setNavigationItemSelectedListener(mainPresenter);
        //侧滑菜单头部控件数据持有者
        nvh = new NavHeaderViewHolder(vh.navView.getHeaderView(0));
        nvh.tvMainLoginReg.setOnClickListener(view -> startActivityFromTo(MainActivity.this, LoginActivity.class));

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
        vh.fab.setOnClickListener(view -> Snackbar.make(view, "替换为你的动作", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
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
