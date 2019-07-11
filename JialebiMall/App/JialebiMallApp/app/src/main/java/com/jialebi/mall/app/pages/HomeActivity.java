package com.jialebi.mall.app.pages;

import android.view.View;
import android.widget.Toast;

import com.chris.base.library.base.activity.BaseActivity;
import com.jialebi.mall.app.R;

/**
 * @author Chris Chan
 * on 2019/7/11 9:40
 * use for:
 */
public class HomeActivity extends BaseActivity {
    @Override
    protected void onReady() {
        Toast.makeText(this, "哈哈！佳乐比商城！", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View createContentView() {
        return getLayoutInflater().inflate(R.layout.act_home, null);
    }
}
