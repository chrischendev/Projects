package com.chris.base.library.base.event;

/**
 * @author Chris Chan
 * on 2019/7/9 17:27
 * use for:
 */
public class BaseEvent<T> {
    public static final int EVENT_SUCCESS = 0x00000001;
    public static final int EVENT_ERROR = 0x00000002;

    public int code = EVENT_SUCCESS;//消息状态码
    public String msg;//提示信息
    public T data;//封装的传递数据

    public BaseEvent() {
    }

    public BaseEvent(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static <T> BaseEvent create(int code, String msg, T data) {
        return new BaseEvent(code, msg, data);
    }
}
