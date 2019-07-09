package com.mars.edu.app.library.base.activity;

import android.os.Bundle;

/**
 * @author Chris Chan
 * on 2019/7/8 10:36
 * use for: 封装dagger注入的相关处理
 * 基于butterknife
 */
public abstract class BaseInjectActivity extends BaseBindActivity {
    @Override
    public void init(Bundle savedInstanceState) {
        initInject();
    }

    /**
     * 初始化注入
     */
    public abstract void initInject();
}
