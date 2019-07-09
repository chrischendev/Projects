package com.mars.edu.app.pages.home;

import javax.inject.Inject;

/**
 * @author Chris Chan
 * on 2019/7/9 10:38
 * use for:
 */
public class HomePresenter implements HomeContracts.Presenter {
    private HomeContracts.View view;

    @Inject
    public HomePresenter() {
    }

    @Override
    public void bind(HomeContracts.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }
}
