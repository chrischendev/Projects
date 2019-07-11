package com.mars.edu.app.api.teacher;

import com.chris.base.library.net.NetClient;
import com.chris.base.library.net.NetResult;
import com.chris.base.library.net.NetResultCallback;
import com.mars.edu.app.locallibs.net.juhe.UrlConsts;
import com.mars.edu.app.model.TeacherModel;

import java.util.List;

import retrofit2.Call;

/**
 * @author Chris Chan
 * on 2019/7/10 14:55
 * use for:
 */
public class TeacherApi implements UrlConsts {
    private static TeacherService service = NetClient.getRetrofit(MARS_BASE_URL).create(TeacherService.class);

    /**
     * 获取教职工集合
     *
     * @param callback
     */
    public static void getTeacherList(NetResultCallback<List<TeacherModel>> callback) {
        Call<NetResult<List<TeacherModel>>> call = service.getTeacherList();
        call.enqueue(callback);
    }
}
