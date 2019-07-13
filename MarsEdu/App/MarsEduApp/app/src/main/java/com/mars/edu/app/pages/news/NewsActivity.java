package com.mars.edu.app.pages.news;

import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.chris.base.library.base.activity.BaseInjectActivity;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * create by Chris Chan
 * create on 2019/7/10 0:06
 * use for :
 */
public class NewsActivity extends BaseInjectActivity {
    @Inject
    List<NewsFragment> fragmentList;

    private ViewHolder vh;
    private NewsFragmentAdapter newsFragmentAdapter;

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.act_news;
    }

    @Override
    public void createViewHolder() {
        vh = new ViewHolder(getContentView());
    }

    @Override
    protected void onReady() {
        //ViewPager
        FragmentManager fragmentManager = getSupportFragmentManager();
        newsFragmentAdapter = new NewsFragmentAdapter(fragmentManager, fragmentList);
        vh.vpNews.setOffscreenPageLimit(4);
        vh.vpNews.setAdapter(newsFragmentAdapter);
        //TabLayout
        vh.tabNewsType.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        vh.tabNewsType.setupWithViewPager(vh.vpNews);
        vh.tabNewsType.removeAllTabs();
        for (int i = 0, len = fragmentList.size(); i < len; i++) {
            TabLayout.Tab tab = vh.tabNewsType.newTab();
            tab.setText(fragmentList.get(i).getTypeName());
            vh.tabNewsType.addTab(tab);
        }

    }

    static
    class ViewHolder {
        @BindView(R.id.tab_news_type)
        TabLayout tabNewsType;
        @BindView(R.id.vp_news)
        ViewPager vpNews;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
