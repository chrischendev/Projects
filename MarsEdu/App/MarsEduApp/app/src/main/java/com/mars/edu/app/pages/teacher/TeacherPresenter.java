package com.mars.edu.app.pages.teacher;

import android.content.Context;
import android.widget.Toast;

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

    public void show(Context context) {
        Toast.makeText(context, "哈哈哈哈！", Toast.LENGTH_SHORT).show();
    }
}
