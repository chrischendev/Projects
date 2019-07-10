package com.mars.edu.app.locallibs.inject;

import com.mars.edu.app.pages.news.NewsFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Chris Chan
 * on 2019/7/5 14:52
 * use for:
 */
@Singleton
@Component(modules = {FragmentModule.class})
public interface FragmentComponent {
    void inject(NewsFragment fragment);
}
