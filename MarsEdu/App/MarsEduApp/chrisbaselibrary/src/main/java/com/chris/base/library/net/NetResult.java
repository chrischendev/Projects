package com.chris.base.library.net;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:06
 * use for :
 */
public class NetResult<T> {
    public int code;
    public String msg;
    public T data;

    public NetResult() {
    }

    public NetResult(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
}
