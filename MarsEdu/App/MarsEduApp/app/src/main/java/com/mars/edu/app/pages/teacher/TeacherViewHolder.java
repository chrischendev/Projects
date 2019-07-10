package com.mars.edu.app.pages.teacher;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.mars.edu.app.R;
import com.mars.edu.app.library.base.viewholder.BaseViewHolder;

import butterknife.BindView;

/**
 * @author Chris Chan
 * on 2019/7/5 14:59
 * use for:
 */
public class TeacherViewHolder extends BaseViewHolder {
    @BindView(R.id.rv_teacher)
    RecyclerView rvTeacher;

    public TeacherViewHolder(Context context) {
        super(context);
    }

    public TeacherViewHolder(View view) {
        super(view);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.act_teacher;
    }
}

