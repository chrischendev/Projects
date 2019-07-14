package com.mars.edu.video;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chris.base.library.base.activity.BaseInjectActivity;

/**
 * create by Chris Chan
 * create on 2019/7/14 10:36
 * use for :
 */
@Route(path = "/video/VideoActivity")
public class VideoActivity extends BaseInjectActivity {
    @Override
    public void initInject() {

    }

    @Override
    public int layoutId() {
        return R.layout.act_video;
    }

    @Override
    protected void onReady() {

    }
}
