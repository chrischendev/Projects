package com.mars.edu.app.pages.picture;

import android.widget.Toast;

import com.chris.base.library.base.activity.BaseMvpActivity;
import com.chris.base.library.base.mvp.BasePresenter;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;

import javax.inject.Inject;

/**
 * create by Chris Chan
 * create on 2019/9/11 2:52
 * use for :
 */
public class PictureActivity extends BaseMvpActivity implements PictureContracts.View {
    @Inject
    PicturePresenter presenter;

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.act_picture;
    }

    @Override
    protected void onReady() {
        Toast.makeText(this, "新相册", Toast.LENGTH_SHORT).show();
    }
}
