package com.mars.edu.app.pages.picture;

import javax.inject.Inject;

/**
 * create by Chris Chan
 * create on 2019/9/11 3:00
 * use for :
 */
public class PicturePresenter implements PictureContracts.Presenter {
    private PictureContracts.View view;

    @Inject
    public PicturePresenter() {
    }

    @Override
    public void bind(PictureContracts.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }
}
