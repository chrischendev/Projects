package com.mars.edu.app.pages.teacher;

import android.content.Context;
import android.widget.TextView;

import com.mars.edu.app.R;
import com.mars.edu.app.base.BaseViewHolder;

import butterknife.BindView;

/**
 * @author Chris Chan
 * on 2019/7/5 14:59
 * use for:
 */
public class TeacherViewHolder extends BaseViewHolder {

    @BindView(R.id.tv_info)
    TextView tvInfo;

    public TeacherViewHolder(Context context) {
        super(context);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_teacher;
    }
}

