package com.chris.base.library.base.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.io.Serializable;

/**
 * @author Chris Chan
 * on 2019/7/8 10:16
 * use for:
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 主要内容布局控件
     */
    public View contentView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preSetContentView(savedInstanceState);
        contentView = createContentView();
        setContentView(contentView);
        postContentView(savedInstanceState);
        onReady();
    }

    /**
     * 一切都准备好了
     */
    protected abstract void onReady();

    /**
     * 在设置完主要内容控件之后执行
     *
     * @param savedInstanceState
     */
    public void postContentView(Bundle savedInstanceState) {
    }

    /**
     * 创建主要内容布局
     * 一般在这里把布局文件实例化为控件
     *
     * @return
     */
    public abstract View createContentView();

    /**
     * 在设置主要内容布局之前执行
     *
     * @param savedInstanceState
     */
    public void preSetContentView(Bundle savedInstanceState) {
    }

    /**
     * 获取主要内容布局
     *
     * @return
     */
    public View getContentView() {
        return contentView;
    }

    /**
     * 跳转到其他的Activity
     * 适用于内部类
     *
     * @param packageContext
     * @param clazz
     */
    protected void startActivityFromTo(Context packageContext, Class clazz) {
        startActivity(new Intent(packageContext, clazz));
    }

    /**
     * 跳转到其他的Activity并结束
     * 适用于内部类
     *
     * @param clazz
     */
    protected void startActivityFromToAndFinished(Context packageContext, Class clazz) {
        startActivity(new Intent(packageContext, clazz));
        finish();
    }

    /**
     * 跳转到其他的Activity
     *
     * @param clazz
     */
    protected void startActivity(Class clazz) {
        startActivity(new Intent(this, clazz));
    }

    /**
     * 跳转到其他的Activity并且结束当前的Activity
     *
     * @param clazz
     */
    protected void startActivityAndFinished(Class clazz) {
        startActivity(clazz);
        finish();
    }

    /**
     * 跳转到其他的Activity并且携带数据
     *
     * @param clazz
     * @param key
     * @param value
     */
    protected void startActivityWithExtra(Class clazz, String key, Serializable value) {
        Intent intent = new Intent(this, clazz);
        intent.putExtra(key, value);
        startActivity(intent);
    }

    /**
     * 携带数据跳转到其他的Activity，并且结束当前Activity
     *
     * @param clazz
     * @param key
     * @param value
     */
    protected void startActivityWithExtraAndFinished(Class clazz, String key, Serializable value) {
        startActivityWithExtra(clazz, key, value);
        finish();
    }

    /**
     * 通过Intent对象跳转到其他Activity，并且结束当前Activity
     *
     * @param intent
     */
    protected void startActivityIntentAndFinished(Intent intent) {
        startActivity(intent);
        finish();
    }

    /**
     * 跳转到其他Activity并处理返回结果
     *
     * @param clazz
     * @param requestCode
     */
    protected void startActivityForResult(Class clazz, int requestCode) {
        startActivityForResult(new Intent(this, clazz), requestCode);
    }

    /**
     * 跳转到其他Activity并处理返回结果
     *
     * @param clazz
     */
    protected void startActivityForResult(Class clazz) {
        startActivityForResult(new Intent(this, clazz), 0);
    }
}
