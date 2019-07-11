package com.mars.edu.app.pages.teacher;

import android.content.Context;
import android.view.View;

import com.chris.base.library.base.adapter.BaseRecyclerAdapter;
import com.mars.edu.app.R;
import com.mars.edu.app.model.TeacherModel;

import java.util.List;

/**
 * @author Chris Chan
 * on 2019/7/10 15:12
 * use for:
 */
public class TeacherRvAdapter extends BaseRecyclerAdapter<TeacherModel, TeacherRvViewHolder> {
    public TeacherRvAdapter(Context context, List<TeacherModel> dataList) {
        super(context, dataList);
    }

    @Override
    protected int layoutId() {
        return R.layout.item_of_teacher;
    }

    @Override
    protected TeacherRvViewHolder createViewHolder(View itemView) {
        return new TeacherRvViewHolder(context, itemView);
    }

    @Override
    protected void refreshItemView(TeacherRvViewHolder holder, TeacherModel item) {
        holder.refreshView(item);
    }
}
