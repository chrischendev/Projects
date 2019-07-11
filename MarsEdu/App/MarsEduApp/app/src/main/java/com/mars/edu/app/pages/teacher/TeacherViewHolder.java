package com.mars.edu.app.pages.teacher;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chris.base.library.base.viewholder.BaseViewHolder;
import com.mars.edu.app.R;

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

