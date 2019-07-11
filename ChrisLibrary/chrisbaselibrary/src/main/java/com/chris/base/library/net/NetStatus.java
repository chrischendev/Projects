package com.chris.base.library.net;

/**
 * create by Chris Chan
 * create on 2019/7/9 23:09
 * use for :
 */
public enum NetStatus {
    SUCCESS(0, "请求成功"),
    DATA_EMPTY(1, "数据为空"),
    DATA_ERROR(2, "数据错误"),
    NET_ERROR(3, "网络错误");

    private int code;
    private String message;

    NetStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }}
