package com.mars.edu.app.pages.teacher;

import android.widget.Toast;

import com.mars.edu.app.R;
import com.mars.edu.app.base.BaseActivity;
import com.mars.edu.app.inject.DaggerActivityComponent;
import com.mars.edu.app.model.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.OnClick;

public class TeacherActivity extends BaseActivity<TeacherViewHolder> implements TeacherContracts.View {
    @Inject
    User user;
    @Inject
    List<String> nameList;
    @Inject
    TeacherPresenter presenter;

    @Override
    protected TeacherViewHolder createViewHolder() {
        return new TeacherViewHolder(this);
    }

    @Override
    protected void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    protected void initViewAndListener() {
        presenter.bind(this);
        viewHolder.tvInfo.setText("Hello，Android！");
        presenter.show(this);
    }

    @OnClick(R.id.tv_info)
    public void onViewClicked() {
        Toast.makeText(this, "OK!" + user.name, Toast.LENGTH_SHORT).show();
        viewHolder.tvInfo.setText(nameList.get(1));
    }

    @Override
    public void loadData() {

    }

    @Override
    public void updateData() {

    }

    @Override
    protected void onDestroy() {
        presenter.unbind();
        super.onDestroy();
    }
}
