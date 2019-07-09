package com.mars.edu.app.library.base.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @author Chris Chan
 * on 2019/7/9 16:54
 * use for:
 */
public abstract class BaseFragment extends Fragment {
    protected Context context;
    protected View contentView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.contentView = inflater.inflate(layoutId(), container, false);
        return this.contentView;
    }

    protected abstract @LayoutRes
    int layoutId();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        preViewCreate(view, savedInstanceState);
        super.onViewCreated(view, savedInstanceState);
        postViewCreated(view, savedInstanceState);
    }

    protected abstract void preViewCreate(View view, Bundle savedInstanceState);

    protected abstract void postViewCreated(View view, Bundle savedInstanceState);

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.context = activity;
    }

    public Context getBaseContext() {
        return this.context;
    }

    /**
     * 跳转到其他的Activity
     *
     * @param clazz
     */
    protected void startActivity(Class clazz) {
        Intent intent = new Intent(getContext(), clazz);
        startActivity(intent);
    }
}
