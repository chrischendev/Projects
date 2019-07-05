package com.mars.edu.app.pages.teacher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.mars.edu.app.R;
import com.mars.edu.app.inject.DaggerActivityComponent;
import com.mars.edu.app.pages.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeacherActivity extends AppCompatActivity implements TeacherContracts.View {
    @Inject
    User user;
    @Inject
    List<String> nameList;
    @Inject
    TeacherPresenter presenter;

    private TeacherViewHolder viewHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewHolder = new TeacherViewHolder(this);
        setContentView(viewHolder.getView());
        ButterKnife.bind(this);

        initInject();
        initView();
    }

    private void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    private void initView() {
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
