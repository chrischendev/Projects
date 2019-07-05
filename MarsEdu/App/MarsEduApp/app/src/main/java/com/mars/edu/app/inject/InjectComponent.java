package com.mars.edu.app.inject;

import android.app.Activity;
import android.support.v4.app.Fragment;

import dagger.Component;

@Component(modules = {InjectModule.class})
public interface InjectComponent {
    void inject(Activity activity);

    void inject(Fragment fragment);
}
