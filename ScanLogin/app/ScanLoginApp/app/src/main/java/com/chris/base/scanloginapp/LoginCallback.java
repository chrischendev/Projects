package com.chris.base.scanloginapp;

/**
 * create by Chris Chan
 * create on 2019/10/2 16:46
 * use for :
 */
public interface LoginCallback<T> {
    void success(T data);

    void failed(String message, Throwable t);
}
