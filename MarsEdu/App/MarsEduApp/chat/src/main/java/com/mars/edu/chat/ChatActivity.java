package com.mars.edu.chat;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chris.base.library.base.activity.BaseActivity;

/**
 * @author Chris Chan
 * on 2019/7/12 15:35
 * use for:
 */
@Route(path = "/chat/ChatActivity")
public class ChatActivity extends BaseActivity {

    @Override
    protected void onReady() {
        System.out.println("hahahahahah");
    }

    @Override
    public View createContentView() {
        return getLayoutInflater().inflate(R.layout.act_chat, null);
    }
}
