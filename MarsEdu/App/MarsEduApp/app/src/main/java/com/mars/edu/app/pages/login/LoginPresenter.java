package com.mars.edu.app.pages.login;

import javax.inject.Inject;

/**
 * @author Chris Chan
 * on 2019/7/8 15:32
 * use for:
 */
public class LoginPresenter implements LoginContracts.Presenter {
    private LoginContracts.View view;

    @Inject
    public LoginPresenter() {
    }

    @Override
    public void bind(LoginContracts.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    @Override
    public void requestData() {
        view.updateData();
    }
}
