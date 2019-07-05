package com.mars.edu.app.pages.teacher;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.mars.edu.app.R;
import com.mars.edu.app.inject.DaggerInjectComponent;
import com.mars.edu.app.pages.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TeacherActivity extends AppCompatActivity {

    @BindView(R.id.tv_info)
    TextView tvInfo;

    @Inject
    User user;
    @Inject
    List<String> nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_teacher);
        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        DaggerInjectComponent.create().inject(this);
        tvInfo.setText("你好，安卓！");
    }

    @OnClick(R.id.tv_info)
    public void onViewClicked() {
        Toast.makeText(this, "OK!" + user.name, Toast.LENGTH_SHORT).show();
        tvInfo.setText(nameList.get(0));
    }
}
