package com.chris.life.api.common;

import java.util.List;

/**
 * 聚合数据 数据结果 结构
 */
public class JuheResult<T> {
    private String stat;
    private List<T> data;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
