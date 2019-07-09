package com.mars.edu.app.library.net;

import java.util.List;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:07
 * use for :
 */
public class NetListResult<T> {
    public int code;
    public String message;
    public List<T> dataList;

    public NetListResult() {
    }

    public NetListResult(int code, String message, List<T> dataList) {
        this.code = code;
        this.message = message;
        this.dataList = dataList;
    }
}
