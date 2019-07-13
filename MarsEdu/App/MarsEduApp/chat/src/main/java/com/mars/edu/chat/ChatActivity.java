package com.mars.edu.chat;

import android.view.View;

import com.chris.base.library.base.activity.BaseActivity;

/**
 * @author Chris Chan
 * on 2019/7/12 15:35
 * use for:
 */
public class ChatActivity extends BaseActivity {

    @Override
    protected void onReady() {
        System.out.println("hahahahahah");
    }

    @Override
    public View createContentView() {
        return getLayoutInflater().inflate(R.layout.act_main, null);
    }
}
