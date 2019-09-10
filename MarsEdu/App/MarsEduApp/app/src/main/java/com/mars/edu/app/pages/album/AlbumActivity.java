package com.mars.edu.app.pages.album;

import android.view.View;
import android.widget.Gallery;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chris.base.library.base.activity.BaseInjectActivity;
import com.mars.edu.app.R;
import com.mars.edu.app.locallibs.inject.DaggerActivityComponent;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * create by Chris Chan
 * create on 2019/7/13 23:38
 * use for : 相册
 * 同时测试路由跳转功能
 */
@Route(path = "/app/AlbumActivity")
public class AlbumActivity extends BaseInjectActivity {
    private ViewHolder vh;
    private ImageAdapter adapter;

    @Override
    public void initInject() {
        DaggerActivityComponent.create().inject(this);
    }

    @Override
    public int layoutId() {
        return R.layout.act_album;
    }

    @Override
    public void createViewHolder() {
        vh = new ViewHolder(getContentView());
    }

    @Override
    protected void onReady() {
        Toast.makeText(this, "相册", Toast.LENGTH_SHORT).show();

        int[] imageReses = {R.mipmap.ic_launcher_round,
                R.mipmap.ic_launcher_round,
                R.mipmap.ic_launcher_round,
                R.mipmap.ic_launcher_round};
        adapter=new ImageAdapter(this,imageReses);
        vh.galleryImage.setAdapter(adapter);
    }

    static
    class ViewHolder {
        @BindView(R.id.gallery_image)
        Gallery galleryImage;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
