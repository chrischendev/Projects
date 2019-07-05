package com.mars.edu.app.inject;

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
}
