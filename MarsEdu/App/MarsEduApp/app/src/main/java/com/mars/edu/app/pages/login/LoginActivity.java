package com.mars.edu.app.pages.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.mars.edu.app.R;
import com.mars.edu.app.library.base.activity.BaseMvpActivity;
import com.mars.edu.app.library.base.mvp.BasePresenter;
import com.mars.edu.app.library.utils.SPUtils;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;
import com.mars.edu.app.model.User;
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
    private static final String def_username = "chris";
    private static final String def_upassword = "123456";
    @Inject
    LoginPresenter loginPresenter;
    @Inject
    User loginUser;

    private ViewHolder vh;

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return loginPresenter;
    }

    @Override
    protected View createViewHolderByLayoutId() {
        contentView = getLayoutInflater().inflate(layoutId(), null);
        vh = new ViewHolder(contentView);
        return contentView;
    }

    @Override
    public int layoutId() {
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
        String username = SPUtils.read("username", null);
        if (null != username) {
            startActivityAndFinished(MainActivity.class);
        } else {
            vh.tvUsername.setText(def_username);
            vh.tvPassword.setText(def_upassword);
        }
    }


    @OnClick({R.id.btn_login})
    public void onClick(View view) {
        String username = vh.tvUsername.getText().toString().trim();
        String password = vh.tvPassword.getText().toString().trim();
        if (loginUser.username.equalsIgnoreCase(username) && loginUser.password.equalsIgnoreCase(password)) {
            SPUtils.save("username", username);
            SPUtils.save("password", password);
            startActivityAndFinished(MainActivity.class);
        } else {
            Toast.makeText(this, "用户名或者密码错误", Toast.LENGTH_SHORT).show();
            vh.tvUsername.setText(null);
            vh.tvPassword.setText(null);
            vh.tvUsername.setFocusable(true);
            vh.tvUsername.setFocusableInTouchMode(true);
            vh.tvUsername.requestFocus();

            vh.tvUsername.setText(def_username);
            vh.tvPassword.setText(def_upassword);
        }
    }

    @Override
    public void loadData(User data) {

    }

    @Override
    public void updateData(User data) {

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
