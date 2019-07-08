package com.mars.edu.app.inject;

import com.mars.edu.app.pages.login.LoginActivity;
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

    void inject(TeacherActivity activity);
}
