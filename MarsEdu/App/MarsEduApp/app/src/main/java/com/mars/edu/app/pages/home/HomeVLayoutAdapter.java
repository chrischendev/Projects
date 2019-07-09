package com.mars.edu.app.pages.home;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.ViewGroup;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.LinearLayoutHelper;
import com.mars.edu.app.pages.main.MainNavItem;

import java.util.List;

/**
 * @author Chris Chan
 * on 2019/7/9 11:15
 * use for:
 */
public class HomeVLayoutAdapter extends DelegateAdapter.Adapter<HomeRvViewHolder> {
    private Context context;
    private List<MainNavItem> dataList;

    public HomeVLayoutAdapter(Context context, List<MainNavItem> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        return new LinearLayoutHelper();
    }

    @NonNull
    @Override
    public HomeRvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new HomeRvViewHolder(context, viewGroup.getChildAt(i));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRvViewHolder homeRvViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
