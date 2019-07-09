package com.mars.edu.app.pages.news;

import android.widget.Toast;

import com.mars.edu.app.api.news.NewsApi;
import com.mars.edu.app.locallibs.net.NewsItem;
import com.mars.edu.app.locallibs.net.juhe.JuheResponse;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * create by Chris Chan
 * create on 2019/7/10 0:10
 * use for :
 */
public class NewsPresenter implements NewsContracts.Presenter {
    private NewsContracts.View view;

    @Inject
    public NewsPresenter() {
    }

    @Override
    public void requestData() {
        NewsApi.getNewsList("top", new Callback<JuheResponse<NewsItem>>() {
            @Override
            public void onResponse(Call<JuheResponse<NewsItem>> call, Response<JuheResponse<NewsItem>> response) {
                view.updateData(response.body().getResult().getData());
            }

            @Override
            public void onFailure(Call<JuheResponse<NewsItem>> call, Throwable t) {
                Toast.makeText(view.getOwnContext(), "请求出错", Toast.LENGTH_SHORT).show();
                t.printStackTrace();
            }
        });
    }

    @Override
    public void bind(NewsContracts.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }
}
