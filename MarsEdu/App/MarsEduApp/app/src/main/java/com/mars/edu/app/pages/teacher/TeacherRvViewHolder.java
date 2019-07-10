package com.mars.edu.app.pages.teacher;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.mars.edu.app.R;
import com.mars.edu.app.library.base.viewholder.BaseRecyclerHolder;
import com.mars.edu.app.library.utils.GlideUtils;
import com.mars.edu.app.model.TeacherModel;

import butterknife.BindView;

/**
 * @author Chris Chan
 * on 2019/7/10 15:10
 * use for:
 */
public class TeacherRvViewHolder extends BaseRecyclerHolder<TeacherModel> {
    @BindView(R.id.iv_photo)
    ImageView ivPhoto;
    @BindView(R.id.tv_teacher_name)
    TextView tvTeacherName;
    @BindView(R.id.tv_identity_card_code)
    TextView tvIdentityCardCode;
    @BindView(R.id.tv_school_id)
    TextView tvSchoolId;
    @BindView(R.id.tv_cell)
    TextView tvCell;
    @BindView(R.id.tv_email)
    TextView tvEmail;
    @BindView(R.id.tv_qq)
    TextView tvQq;

    public TeacherRvViewHolder(Context context, View itemView) {
        super(context, itemView);
    }

    @Override
    protected void refreshView(TeacherModel item) {
        GlideUtils.load(context, R.mipmap.nav_header_photo_0, ivPhoto);
        tvTeacherName.setText(item.firstName + item.lastName);
        tvIdentityCardCode.setText(item.identityCardCode);
        tvSchoolId.setText("" + item.schoolId);
        tvCell.setText(item.cell);
        tvEmail.setText(item.email);
        tvQq.setText(item.qqCode);
    }
}
