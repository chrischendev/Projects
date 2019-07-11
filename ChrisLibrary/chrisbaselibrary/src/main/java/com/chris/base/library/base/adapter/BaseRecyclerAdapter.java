package com.chris.base.library.base.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chris.base.library.base.viewholder.BaseRecyclerHolder;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Chris Chen on 2017/7/3 17:18.
 * Explain:RecyclerView的Adapter基类
 */

public abstract class BaseRecyclerAdapter<D, H extends BaseRecyclerHolder> extends RecyclerView.Adapter {
    protected Context context;
    protected List<D> dataList;
    protected View itemView;
    protected OnItemClickListener<D> onItemClickListener;


    public BaseRecyclerAdapter(Context context, List<D> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    public BaseRecyclerAdapter(Context context, D[] datas) {
        this.context = context;
        this.dataList = Arrays.asList(datas);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int adapterPosition = holder.getAdapterPosition();
        final D item = getItem(adapterPosition);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(view, adapterPosition, item);
                }
            }
        });

        refreshView((H) holder, position);
    }

    @Override
    public H onCreateViewHolder(ViewGroup parent, int viewType) {
        itemView = LayoutInflater.from(context).inflate(layoutId(), parent, false);
        return createViewHolder(itemView);
    }

    /**
     * 布局文件
     *
     * @return
     */
    protected abstract int layoutId();

    /**
     * 创建ViewHolder
     *
     * @param itemView
     * @return
     */
    protected abstract H createViewHolder(View itemView);

    /**
     * 刷新数据
     *
     * @param holder
     * @param position
     */
    protected void refreshView(H holder, int position) {
        refreshItemView(holder, getItem(position));
    }

    /**
     * 刷新列表项
     *
     * @param holder
     * @param item
     */
    protected abstract void refreshItemView(H holder, D item);

    @Override
    public int getItemCount() {
        return null == this.dataList ? 0 : this.dataList.size();
    }

    /**
     * 获取列表项数据
     *
     * @param position
     * @return
     */
    public D getItem(int position) {
        return null == this.dataList ? null : this.dataList.get(position);
    }

    public void setOnItemClickListener(OnItemClickListener<D> onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    /**
     * 更新数据
     *
     * @param dataList
     */
    public void updateData(List<D> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();
    }

    public void updateData(D[] datas) {
        this.dataList = Arrays.asList(datas);
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     *
     * @param dataList
     */
    public void loadMore(List<D> dataList) {
        this.dataList.addAll(dataList);
        notifyDataSetChanged();
    }

    /**
     * 加载更多
     *
     * @param datas
     */
    public void loadMore(D[] datas) {
        this.dataList.addAll(Arrays.asList(datas));
        notifyDataSetChanged();
    }

    /**
     * 列表项点击事件监听
     */
    public interface OnItemClickListener<D> {
        void onItemClick(View itemView, int position, D item);
    }
}

