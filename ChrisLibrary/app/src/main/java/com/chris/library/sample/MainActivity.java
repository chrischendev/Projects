package com.chris.library.sample;

import android.view.View;
import android.widget.Toast;

import com.chris.base.library.base.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onReady() {
        Toast.makeText(this, "sample", Toast.LENGTH_SHORT).show();
    }

    @Override
    public View createContentView() {
        return getLayoutInflater().inflate(R.layout.activity_main, null);
    }
}
