package com.mars.edu.app.pages.news;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * @author Chris Chan
 * on 2019/7/10 10:04
 * use for:
 */
public class NewsFragmentAdapter extends FragmentPagerAdapter {
    private List<NewsFragment> fragmentList;

    public NewsFragmentAdapter(FragmentManager fm, List<NewsFragment> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return this.fragmentList.size();
    }
}
