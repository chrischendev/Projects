package com.mars.edu.app.pages.login;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mars.edu.app.R;
import com.mars.edu.app.inject.DaggerActivityComponent;
import com.mars.edu.app.library.base.activity.BaseMvpActivity;
import com.mars.edu.app.library.base.mvp.BasePresenter;
import com.mars.edu.app.pages.main.MainActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Chris Chan
 * on 2019/7/8 14:43
 * use for:
 */
public class LoginActivity extends BaseMvpActivity implements LoginContracts.View {
    @Inject
    LoginPresenter loginPresenter;

    private ViewHolder vh;

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return loginPresenter;
    }

    @SuppressLint("ResourceType")
    @Override
    public int getLayoutId() {
        return R.layout.act_login;
    }

    @Override
    public void createViewHolder() {
        vh = new ViewHolder(getContentView());
    }

    @Override
    protected void onReady() {
        //loginPresenter.requestData();

        ////读取登录用户
        SharedPreferences localuser = getSharedPreferences("localuser", Context.MODE_PRIVATE);
        String username = localuser.getString("username", null);
        if (null == username) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void loadData() {

    }

    @Override
    public void updateData() {
        Toast.makeText(this, "执行成功", Toast.LENGTH_SHORT).show();
    }

    @OnClick({R.id.btn_login})
    public void onClick(View view) {
        String username = vh.tvUsername.getText().toString().trim();
        String password = vh.tvPassword.getText().toString().trim();
        if ("chris".equalsIgnoreCase(username) && "123456".equalsIgnoreCase(password)) {
            SharedPreferences localuser = getSharedPreferences("localuser", Context.MODE_PRIVATE);
            SharedPreferences.Editor edit = localuser.edit();
            edit.putString("username", username);
            edit.putString("password", password);
            edit.commit();
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else {
            Toast.makeText(this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
            vh.tvUsername.setText(null);
            vh.tvPassword.setText(null);
            vh.tvUsername.setFocusable(true);
        }
    }

    static
    class ViewHolder {
        @BindView(R.id.tv_username)
        EditText tvUsername;
        @BindView(R.id.tv_password)
        EditText tvPassword;
        @BindView(R.id.ll_login)
        LinearLayout llLogin;
        @BindView(R.id.btn_login)
        Button btnLogin;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
