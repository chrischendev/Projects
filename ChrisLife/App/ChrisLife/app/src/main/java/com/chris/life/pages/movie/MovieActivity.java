package com.chris.life.pages.movie;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.chris.life.R;

public class MovieActivity extends AppCompatActivity {
    private VideoView vvMov;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_movie);

        initView();
    }

    private void initView() {
        vvMov = findViewById(R.id.vv_movie);

        vvMov.setVideoURI(Uri.parse("http://www.chrischen.com.cn:8081/upload/file_201905250629317293.mp4"));
        vvMov.start();
    }
}
