package com.mars.edu.app.library.net;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:06
 * use for :
 */
public class NetResult<T> {
    public int code;
    public String message;
    public T data;

    public NetResult() {
    }

    public NetResult(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}
