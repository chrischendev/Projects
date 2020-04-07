package com.mars.edu.app.pages.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.alibaba.android.vlayout.DelegateAdapter;
import com.alibaba.android.vlayout.LayoutHelper;
import com.alibaba.android.vlayout.layout.GridLayoutHelper;
import com.alibaba.android.vlayout.layout.OnePlusNLayoutHelper;
import com.mars.edu.app.R;

import java.util.List;

/**
 * @author Chris Chan
 * on 2019/7/9 11:15
 * use for:
 */
public class HomeVLayoutAdapter extends DelegateAdapter.Adapter<HomeRvViewHolder> {
    private Context context;
    private List<HomeModels.NavItem> dataList;
    private int type;

    public HomeVLayoutAdapter(Context context, List<HomeModels.NavItem> dataList, int type) {
        this.context = context;
        this.dataList = dataList;
        this.type = type;
    }

    @Override
    public int getItemViewType(int position) {
        return type;
    }

    @Override
    public LayoutHelper onCreateLayoutHelper() {
        switch (type) {
            case 1:
                GridLayoutHelper gridLayoutHelper = new GridLayoutHelper(4);
                gridLayoutHelper.setItemCount(12);
                //gridLayoutHelper.setMargin(20, 20, 20, 20);
                gridLayoutHelper.setGap(1);
                gridLayoutHelper.setAutoExpand(false);
                //gridLayoutHelper.setPadding(20, 20, 20, 20);
                gridLayoutHelper.setSpanSizeLookup(new GridLayoutHelper.SpanSizeLookup() {
                    @Override
                    public int getSpanSize(int position) {
                        if (position > 3) {
                            return 2;
                        }
                        return 1;
                    }
                });
                return gridLayoutHelper;
            case 2:
                OnePlusNLayoutHelper onePlusNLayoutHelper = new OnePlusNLayoutHelper(5);
                onePlusNLayoutHelper.setColWeights(new float[]{10f});
                onePlusNLayoutHelper.setRowWeight(30f);
                onePlusNLayoutHelper.setMargin(1, 1, 1, 1);
                return onePlusNLayoutHelper;
            default:
                return null;
        }
    }

    @NonNull
    @Override
    public HomeRvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_of_home_nav, viewGroup, false);
        return new HomeRvViewHolder(context, view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeRvViewHolder homeRvViewHolder, int i) {
        homeRvViewHolder.refreshView(dataList.get(i));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}
