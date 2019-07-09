package com.mars.edu.app.pages.teacher;

import android.widget.Toast;

import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;
import com.mars.edu.app.library.base.activity.BaseMvpActivity;
import com.mars.edu.app.library.base.mvp.BasePresenter;
import com.mars.edu.app.model.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;

public class TeacherActivity extends BaseMvpActivity implements TeacherContracts.View {
    @Inject
    User user;
    @Inject
    List<String> nameList;
    @Inject
    TeacherPresenter teacherPresenter;

    private TeacherViewHolder vh;

    @Override
    public int layoutId() {
        return R.layout.act_teacher;
    }

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return teacherPresenter;
    }

//    @Override
//    protected View createViewHolderByLayoutId() {
//        vh = new TeacherViewHolder(this);
//        return vh.getView();
//    }


    @Override
    public void createViewHolder() {
        vh = new TeacherViewHolder(getContentView());
    }

    @Override
    protected void onReady() {
        vh.tvInfo.setText("教师管理");
    }

    @OnClick(R.id.tv_info)
    public void onViewClicked() {
        Toast.makeText(this, "OK!" + user.username, Toast.LENGTH_SHORT).show();
        vh.tvInfo.setText(nameList.get(1));
    }

}
