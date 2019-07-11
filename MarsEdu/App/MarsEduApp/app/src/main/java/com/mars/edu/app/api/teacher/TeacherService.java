package com.mars.edu.app.api.teacher;

import com.chris.base.library.net.NetResult;
import com.mars.edu.app.model.TeacherModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author Chris Chan
 * on 2019/7/10 14:51
 * use for:
 */
public interface TeacherService {
    @GET("staff/findAll")
    Call<NetResult<List<TeacherModel>>> getTeacherList();
}
