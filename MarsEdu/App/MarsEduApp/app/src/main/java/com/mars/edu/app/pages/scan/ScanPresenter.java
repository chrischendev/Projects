package com.mars.edu.app.pages.scan;

import javax.inject.Inject;

/**
 * @author Chris Chan
 * on 2019/7/10 17:04
 * use for:
 */
public class ScanPresenter implements ScanContracts.Presenter {
    private ScanContracts.View view;

    @Inject
    public ScanPresenter() {
    }

    @Override
    public void bind(ScanContracts.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }
}
