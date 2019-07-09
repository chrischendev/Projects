package com.mars.edu.app.api.joke;

import com.mars.edu.app.library.net.NetClient;
import com.mars.edu.app.locallibs.net.JokeItem;
import com.mars.edu.app.locallibs.net.juhe.JuheResponse;
import com.mars.edu.app.locallibs.net.juhe.UrlConsts;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Chris Chen on 2019/7/9 17:09.
 * Explain:笑话 api
 */

public class JokeApi implements UrlConsts {
    private static JokeService service = NetClient.getRetrofit(JUHE_V_BASE_URL).create(JokeService.class);
    private static final String KEY = "286a2956dad55da66095a1f75bf6a464";

    //获取商品分类列表
    //请求示例：http://v.juhe.cn/joke/content/list.php?key=您申请的KEY&page=2&pagesize=10&sort=asc&time=1418745237
    public static void getJokeList(int page, int pagesize, String sort, long time, Callback<JuheResponse<JokeItem>> callback) {
        Map<String, Object> map = new HashMap<>();
        map.put("key", KEY);
        map.put("page", page);//页码 当前页数,默认1
        map.put("pagesize", pagesize);//页面 每次返回条数,默认1,最大20
        map.put("sort", sort);//排序 类型，desc:指定时间之前发布的，asc:指定时间之后发布的
        map.put("time", time);//时间 时间戳（10位），如：1418816972
        Call call = service.getJokeList(map);
        call.enqueue(callback);
    }

}
