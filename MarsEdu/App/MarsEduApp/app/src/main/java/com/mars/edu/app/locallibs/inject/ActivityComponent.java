package com.mars.edu.app.locallibs.inject;

import com.mars.edu.app.pages.album.AlbumActivity;
import com.mars.edu.app.pages.home.HomeActivity;
import com.mars.edu.app.pages.login.LoginActivity;
import com.mars.edu.app.pages.main.MainActivity;
import com.mars.edu.app.pages.news.NewsActivity;
import com.mars.edu.app.pages.news.NewsDetailActivity;
import com.mars.edu.app.pages.picture.PictureActivity;
import com.mars.edu.app.pages.scan.ScanActivity;
import com.mars.edu.app.pages.teacher.TeacherActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * @author Chris Chan
 * on 2019/7/5 14:50
 * use for:
 */
@Singleton
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    void inject(LoginActivity activity);

    void inject(MainActivity activity);

    void inject(TeacherActivity activity);

    void inject(HomeActivity activity);

    void inject(NewsActivity activity);

    void inject(NewsDetailActivity activity);

    void inject(ScanActivity activity);

    void inject(AlbumActivity activity);

    void inject(PictureActivity activity);
}
