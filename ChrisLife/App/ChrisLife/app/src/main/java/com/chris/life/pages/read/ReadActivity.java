package com.chris.life.pages.read;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.chris.life.R;
import com.chris.life.pages.read.joke.JokeFragment;
import com.chris.life.pages.read.joke.dummy.JokeContent;
import com.chris.life.pages.read.news.NewsDetailActivity;
import com.chris.life.pages.read.news.NewsFragment;
import com.chris.life.pages.read.news.dummy.NewsContent;
import com.chris.life.pages.read.video.VideoFragment;
import com.chris.life.pages.read.video.dummy.VideoContent;

import java.util.ArrayList;
import java.util.List;

public class ReadActivity extends AppCompatActivity implements
        NewsFragment.OnListFragmentInteractionListener,
        VideoFragment.OnListFragmentInteractionListener,
        JokeFragment.OnListFragmentInteractionListener {

    private TextView mTextMessage;

    private ViewPager vpNewsMain;

    List<Fragment> fragmentList = new ArrayList<>();

    private ReadFragmentAdapter adapter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_news:
                    //mTextMessage.setText("首页");
                    vpNewsMain.setCurrentItem(0);
                    return true;
                case R.id.navigation_video:
                    //mTextMessage.setText("视频");
                    vpNewsMain.setCurrentItem(1);
                    return true;
                case R.id.navigation_joke:
                    //mTextMessage.setText("笑话");
                    vpNewsMain.setCurrentItem(2);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_news);

        final BottomNavigationView navView = findViewById(R.id.nav_view);
        vpNewsMain = findViewById(R.id.vp_news_main);

        fragmentList.add(NewsFragment.newInstance(1));
        fragmentList.add(VideoFragment.newInstance(1));
        fragmentList.add(JokeFragment.newInstance(1));

        FragmentManager supportFragmentManager = getSupportFragmentManager();

        adapter = new ReadFragmentAdapter(supportFragmentManager, fragmentList);

        vpNewsMain.setAdapter(adapter);
        vpNewsMain.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                switch (i) {
                    case 0:
                        navView.setSelectedItemId(R.id.navigation_news);
                        break;
                    case 1:
                        navView.setSelectedItemId(R.id.navigation_video);
                        break;
                    case 2:
                        navView.setSelectedItemId(R.id.navigation_joke);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        //mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onListFragmentInteraction(NewsContent.NewsItem item) {
        //Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, NewsDetailActivity.class);
        intent.putExtra("url", item.url);
        intent.putExtra("title", item.title);
        startActivity(intent);
    }

    @Override
    public void onListFragmentInteraction(VideoContent.VideoItem item) {
        Toast.makeText(this, item.title, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onListFragmentInteraction(JokeContent.JokeItem item) {
        Toast.makeText(this, item.hashId, Toast.LENGTH_SHORT).show();
    }
}
