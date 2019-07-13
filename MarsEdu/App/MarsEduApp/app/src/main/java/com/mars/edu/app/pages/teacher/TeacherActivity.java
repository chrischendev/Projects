package com.mars.edu.app.pages.teacher;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.chris.base.library.base.activity.BaseMvpActivity;
import com.chris.base.library.base.adapter.BaseRecyclerAdapter;
import com.chris.base.library.base.mvp.BasePresenter;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;
import com.mars.edu.app.model.TeacherModel;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class TeacherActivity extends BaseMvpActivity implements TeacherContracts.View, BaseRecyclerAdapter.OnItemClickListener<TeacherModel> {
    @Inject
    TeacherPresenter teacherPresenter;

    private TeacherViewHolder vh;
    private TeacherRvAdapter teacherRvAdapter;
    private List<TeacherModel> teacherModelList;

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

    @Override
    public void createViewHolder() {
        vh = new TeacherViewHolder(getContentView());
    }

    @Override
    public void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        teacherModelList = new ArrayList<>();
        teacherRvAdapter = new TeacherRvAdapter(this, teacherModelList);
        teacherRvAdapter.setOnItemClickListener(this);
        vh.rvTeacher.setLayoutManager(new LinearLayoutManager(this));
        vh.rvTeacher.setAdapter(teacherRvAdapter);
    }

    @Override
    protected void onReady() {
        teacherPresenter.requestData();
    }

    @Override
    public void onItemClick(View itemView, int position, TeacherModel item) {
        Toast.makeText(this, item.firstName + item.lastName, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loadData(List<TeacherModel> dataList) {

    }

    @Override
    public void updateData(List<TeacherModel> dataList) {
        teacherRvAdapter.updateData(dataList);
    }

    @Override
    public void loadMore(List<TeacherModel> dataList) {

    }
}
