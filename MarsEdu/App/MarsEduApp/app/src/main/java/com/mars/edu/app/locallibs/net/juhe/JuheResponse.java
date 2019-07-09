package com.mars.edu.app.locallibs.net.juhe;

/**
 * 聚合数据 返回数据结构
 */
public class JuheResponse<T> {
    private Integer errorCode;
    private String resean;
    private JuheResult<T> result;

    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getResean() {
        return resean;
    }

    public void setResean(String resean) {
        this.resean = resean;
    }

    public JuheResult<T> getResult() {
        return result;
    }

    public void setResult(JuheResult<T> result) {
        this.result = result;
    }
}
