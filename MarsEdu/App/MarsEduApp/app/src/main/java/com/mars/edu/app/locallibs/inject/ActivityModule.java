package com.mars.edu.app.locallibs.inject;

import com.mars.edu.app.model.User;
import com.mars.edu.app.pages.news.NewsFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import dagger.Module;
import dagger.Provides;

/**
 * @author Chris Chan
 * on 2019/7/5 14:51
 * use for:
 */
@Module
public class ActivityModule {
    @Provides
    public User user() {
        return new User("chris", "123456");
    }

    @Provides
    public List<String> userNames() {
        String[] names = {"孙菲菲", "姚诗涵", "杨幂"};
        return Arrays.asList(names);
    }

    @Provides
    public List<NewsFragment> newsFragmentList() {
        List<NewsFragment> newsFragmentList = new ArrayList<>();

        newsFragmentList.add(NewsFragment.getInstance("top","头条"));
        newsFragmentList.add(NewsFragment.getInstance("shehui","社会"));
        newsFragmentList.add(NewsFragment.getInstance("guonei","国内"));
        newsFragmentList.add(NewsFragment.getInstance("guoji","国际"));
        newsFragmentList.add(NewsFragment.getInstance("yule","娱乐"));
        newsFragmentList.add(NewsFragment.getInstance("tiyu","体育"));
        newsFragmentList.add(NewsFragment.getInstance("junshi","军事"));
        newsFragmentList.add(NewsFragment.getInstance("keji","科技"));
        newsFragmentList.add(NewsFragment.getInstance("caijing","财经"));
        newsFragmentList.add(NewsFragment.getInstance("shishang","时尚"));

        return newsFragmentList;
    }
}
