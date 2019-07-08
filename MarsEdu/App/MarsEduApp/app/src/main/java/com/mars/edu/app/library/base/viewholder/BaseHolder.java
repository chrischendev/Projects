package com.mars.edu.app.library.base.viewholder;

import android.view.View;

import butterknife.ButterKnife;

/**
 * Created by Chris Chen on 2017/7/3 17:02.
 * Explain:holder基类，依赖于Butterknife
 */

public abstract class BaseHolder {
    public View itemView;
    public BaseHolder(View itemView) {
        this.itemView=itemView;
        ButterKnife.bind(this,itemView);
    }
}
