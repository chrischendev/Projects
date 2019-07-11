package com.mars.edu.app.pages.teacher;

import com.chris.base.library.net.NetResponse;
import com.chris.base.library.net.NetResultCallback;
import com.mars.edu.app.api.teacher.TeacherApi;
import com.mars.edu.app.model.TeacherModel;

import java.util.List;

import javax.inject.Inject;

public class TeacherPresenter implements TeacherContracts.Presenter {
    private TeacherContracts.View view;

    @Inject
    public TeacherPresenter() {
    }

    @Override
    public void bind(TeacherContracts.View view) {
        this.view = view;
    }

    @Override
    public void unbind() {
        this.view = null;
    }

    @Override
    public void requestData() {
        TeacherApi.getTeacherList(new NetResultCallback<List<TeacherModel>>() {
            @Override
            protected void onComplete(NetResponse<List<TeacherModel>> netResponse) {
                if (netResponse.isSuccess) {
                    view.updateData(netResponse.data);
                }
            }
        });
    }
}
