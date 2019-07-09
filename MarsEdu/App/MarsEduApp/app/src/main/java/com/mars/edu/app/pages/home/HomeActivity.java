package com.mars.edu.app.pages.home;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.VirtualLayoutManager;
import com.mars.edu.app.R;
import com.mars.edu.app.inject.DaggerActivityComponent;
import com.mars.edu.app.library.base.activity.BaseMvpActivity;
import com.mars.edu.app.library.base.mvp.BasePresenter;

import java.util.LinkedList;
import java.util.List;

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
    public void init(Bundle savedInstanceState) {
        //初始化RV
        VirtualLayoutManager virtualLayoutManager = new VirtualLayoutManager(this);
        vh.rvHome.setLayoutManager(virtualLayoutManager);

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();
        vh.rvHome.setRecycledViewPool(recycledViewPool);
        recycledViewPool.setMaxRecycledViews(0, 10);

        DelegateAdapter delegateAdapter = new DelegateAdapter(virtualLayoutManager);
        vh.rvHome.setAdapter(delegateAdapter);

        List<DelegateAdapter.Adapter> adapterList = new LinkedList<>();
        delegateAdapter.addAdapters(adapterList);


    }

    @Override
    protected void onReady() {

    }


    static
    class ViewHolder {
        @BindView(R.id.rv_home)
        RecyclerView rvHome;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
