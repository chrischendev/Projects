package com.mars.edu.app.pages.home;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.TextView;

import com.mars.edu.app.R;
import com.mars.edu.app.inject.DaggerActivityComponent;
import com.mars.edu.app.library.base.activity.BaseMvpActivity;
import com.mars.edu.app.library.base.mvp.BasePresenter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Chris Chan
 * on 2019/7/9 10:35
 * use for:
 */
public class HomeActivity extends BaseMvpActivity implements HomeContracts.View {
    @Inject
    HomePresenter homePresenter;

    private ViewHolder vh;

    @Override
    protected BasePresenter getPresenter() {
        return homePresenter;
    }

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @SuppressLint("ResourceType")
    @Override
    public int layoutId() {
        return R.layout.act_home;
    }

    @Override
    public void createViewHolder() {
        vh = new ViewHolder(getContentView());
    }

    @Override
    protected void onReady() {
        vh.tvIfo.setText("雄关漫道真如铁");
    }

    static
    class ViewHolder {
        @BindView(R.id.tv_ifo)
        TextView tvIfo;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
