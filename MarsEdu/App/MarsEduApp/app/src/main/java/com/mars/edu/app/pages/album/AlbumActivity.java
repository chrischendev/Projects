package com.mars.edu.app.pages.album;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chris.base.library.base.activity.BaseInjectActivity;
import com.mars.edu.app.R;

/**
 * create by Chris Chan
 * create on 2019/7/13 23:38
 * use for : 相册
 * 同时测试路由跳转功能
 */
@Route(path = "/app/AlbumActivity")
public class AlbumActivity extends BaseInjectActivity {
    @Override
    public void initInject() {

    }

    @Override
    public int layoutId() {
        return R.layout.act_album;
    }

    @Override
    protected void onReady() {

    }
}
