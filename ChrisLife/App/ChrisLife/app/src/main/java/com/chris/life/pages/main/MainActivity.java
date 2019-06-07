package com.chris.life.pages.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chris.life.R;
import com.chris.life.pages.chat.ChatActivity;
import com.chris.life.pages.movie.MovieActivity;
import com.chris.life.pages.person.MySiteActivity;
import com.chris.life.pages.picture.AlbumActivity;
import com.chris.life.pages.read.ReadActivity;
import com.chris.life.pages.travel.TravelActivity;
import com.chris.life.pages.weather.WeatherActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private ImageView ivAdvice;
    private GridView gridMain;
    private List<MainItem> itemList;
    private MainAdapter adapter;
    private long backTime;//按下返回键的时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "替换为你的动作", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

        ivAdvice = findViewById(R.id.img_main_advice);
        Glide.with(this).load("http://www.chrischen.com.cn:8081/upload/file_201905251108171297.jpg").into(ivAdvice);

        gridMain = findViewById(R.id.grid_main);

        itemList = new ArrayList<>();
        itemList.add(MainItem.create("阅读", R.mipmap.main_item_read));
        itemList.add(MainItem.create("电影", R.mipmap.main_item_movie));
        itemList.add(MainItem.create("旅行", R.mipmap.main_item_travel));
        itemList.add(MainItem.create("天气", R.mipmap.main_item_weather));
        itemList.add(MainItem.create("音乐", R.mipmap.main_item_music));
        itemList.add(MainItem.create("购物", R.mipmap.main_item_shopping));
        itemList.add(MainItem.create("动漫", R.mipmap.main_item_dm));
        itemList.add(MainItem.create("美食", R.mipmap.main_item_dining));
        itemList.add(MainItem.create("游戏", R.mipmap.main_item_game));
        itemList.add(MainItem.create("聊天", R.mipmap.main_item_chat));

        adapter = new MainAdapter(itemList, this);
        gridMain.setAdapter(adapter);
        gridMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, ReadActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, MovieActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, TravelActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, WeatherActivity.class));
                        break;
                    case 4:
                        startActivity(new Intent(MainActivity.this, ReadActivity.class));
                        break;
                    case 5:
                        startActivity(new Intent(MainActivity.this, ReadActivity.class));
                        break;
                    case 6:
                        startActivity(new Intent(MainActivity.this, ReadActivity.class));
                        break;
                    case 7:
                        startActivity(new Intent(MainActivity.this, ReadActivity.class));
                        break;
                    case 8:
                        startActivity(new Intent(MainActivity.this, ReadActivity.class));
                        break;
                    case 9:
                        startActivity(new Intent(MainActivity.this, ChatActivity.class));
                        break;
                    default:
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.action_settings:
                Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.action_qrcode:
                startActivity(new Intent(this, QrCodeActivity.class));
                return true;

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            Intent intent = new Intent(this, MySiteActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "相册", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this, AlbumActivity.class));
        } else if (id == R.id.nav_slideshow) {
            //startActivity(new Intent(this, ReadActivity.class));
            Toast.makeText(this, "文稿", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_tools) {
            Toast.makeText(this, "工具", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "邮件", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {//如果按下返回键
            if (System.currentTimeMillis() - backTime < 1000 * 2) {//如果两秒之内，则退出
                finish();
                return true;
            } else {
                Toast.makeText(this, "再按一次返回键退出应用", Toast.LENGTH_SHORT).show();//提示再按一次退出APP
                backTime = System.currentTimeMillis();//记住新的时间
                return false;
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
